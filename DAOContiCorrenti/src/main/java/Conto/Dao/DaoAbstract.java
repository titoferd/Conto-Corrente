package Conto.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class DaoAbstract<T, INDICE>  implements IDao<T, INDICE> {

    private static final String URL="URL";
    private static final String USERNAME="USERNAME";
    private static final String PASSWORD="PASSWORD";
    private String url;
    private String username;
    private String password;

    private void setting() throws DaoException {
        Properties p = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("./config.properties")) {
            p.load(input);
            this.url = p.getProperty(URL);
            this.username = p.getProperty(USERNAME);
            this.password = p.getProperty(PASSWORD);
        } catch (IOException e) {
            throw new DaoException("il file non esiste");
        }
    }

    protected Connection getConnection() throws DaoException{
        Connection c;
        try{
            if(this.url == null){
                setting();
            }
            c = DriverManager.getConnection(url,username,password);
        }catch(SQLException e){
            throw new DaoException(e.getMessage());
        }
        return c;
    }

    @Override
    public void create(T t) throws DaoException {
        try(Connection cn = getConnection()){
            getPreparedStatementSelect(t, cn).executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    protected abstract PreparedStatement getPreparedStatementSelect(T t, Connection cn) throws SQLException;


    @Override
    public List<T> getAll() throws DaoException {
        List<T> result = new ArrayList<>();
        try(Connection cn = getConnection()){
            ResultSet rs = getPreparedStatementSelectAll(cn).executeQuery();
            while(rs.next()){
                result.add(rsToObject(rs));
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return result;
    }

    protected abstract T rsToObject(ResultSet rs) throws SQLException;

    protected abstract PreparedStatement getPreparedStatementSelectAll(Connection cn) throws SQLException;





    protected abstract PreparedStatement getPreparedStatementUpdate(Connection cn, T t, INDICE indice)  throws SQLException;


    @Override
    public void delete(INDICE indice) throws DaoException {
        try(Connection cn = getConnection()){
            getPreparedStatementDelete(cn, indice).executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    protected abstract PreparedStatement getPreparedStatementDelete(Connection cn, INDICE indice) throws SQLException;





    protected abstract T rsIndexToObject(ResultSet rs) throws SQLException;

    protected abstract PreparedStatement getPreparedStatementFindByIndex(Connection cn, INDICE indice) throws SQLException;



    @Override
    public List<T> findByText(String testo) throws DaoException {
        List<T> result = new ArrayList<>();
        try (Connection cn = getConnection()) {
            ResultSet rs = getPreparedStatementFindByText(cn, testo).executeQuery();
            while(rs.next()){
                result = rsTextToObject(rs);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return result;
    }

    protected abstract List<T> rsTextToObject(ResultSet rs) throws SQLException;

    protected abstract PreparedStatement getPreparedStatementFindByText(Connection cn, String testo) throws SQLException;


}

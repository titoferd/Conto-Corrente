package Conto.Dao;

import Conto.Dto.Conti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoConti extends DaoAbstract<Conti, Long> {

    @Override
    protected PreparedStatement getPreparedStatementSelect(Conti conto, Connection cn) throws SQLException {
        PreparedStatement ps = cn.prepareStatement("insert into ContiCorrenti.conti(CIN, ABI, CAB, nomeTitolare, cognomeTitolare, codiceFiscaleTitolare) values(?, ?, ?, ?, ?, ?)");
       ps.setString(1, conto.getCIN());
       ps.setInt(2, conto.getABI());
       ps.setInt(3, conto.getCAB());
       ps.setString(4,conto.getNomeTitolare());
       ps.setString(5, conto.getCognomeTitolare());
       ps.setString(6,conto.getCodiceFiscaleTitolare());
        return ps;
    }

    @Override
    protected Conti rsToObject(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement getPreparedStatementSelectAll(Connection cn) throws SQLException {
        PreparedStatement preparedStatement = cn.prepareStatement("SELECT * FROM ContiCorrenti.conti");
        return preparedStatement;
    }

    @Override
    protected PreparedStatement getPreparedStatementUpdate(Connection cn, Conti conti, Long aLong) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement getPreparedStatementDelete(Connection cn, Long aLong) throws SQLException {
        return null;
    }

    @Override
    protected Conti rsIndexToObject(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement getPreparedStatementFindByIndex(Connection cn, Long aLong) throws SQLException {
        return null;
    }

    @Override
    protected List<Conti> rsTextToObject(ResultSet rs) throws SQLException {
        return null;
    }
    public List<Conti> findByText(String testo) throws DaoException{
        List<Conti> result = new ArrayList<>();
        try (Connection cn = getConnection()) {
            PreparedStatement ps = cn.prepareStatement("select * from ContiCorrenti.conti where concat(cognomeTitolare, codiceFiscaleTitolare) like ?");
            ps.setString(1, "%"+testo+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String CIN = rs.getString("CIN");
                int ABI = rs.getInt("ABI");
                int CAB =rs.getInt("CAB");
                long numeroConto = rs.getLong("numeroConto");
                String nomeTitolare = rs.getString("nomeTitolare");
                String cognomeTitolare = rs.getString("cognomeTitolare");
                String codiceFiscaleTitolare = rs.getString("codiceFiscaleTitolare");
                result.add(new Conti(CIN, ABI, CAB, numeroConto, nomeTitolare, cognomeTitolare, codiceFiscaleTitolare.toUpperCase()));
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return result;
    }

    @Override
    protected PreparedStatement getPreparedStatementFindByText(Connection cn, String testo) throws SQLException {
        return null;
    }
}

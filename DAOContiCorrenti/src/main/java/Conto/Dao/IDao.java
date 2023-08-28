package Conto.Dao;

import java.util.List;

public interface IDao<T, INDICE> {
    void create(T t) throws DaoException;
    List<T> getAll() throws DaoException;
    void delete(INDICE indice) throws DaoException;
    List<T> findByText(String testo) throws DaoException;

}

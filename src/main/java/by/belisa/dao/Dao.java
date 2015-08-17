package by.belisa.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

import by.belisa.exception.DaoException;

public interface Dao<T, PK extends Serializable> {
	
    /**
     * Get all persisted objects
     *
     * @throws DaoException
     *
     */
    List<T> getAll() throws DaoException;
    /**
     * Get persisted object using primary key
     *
     * @throws DaoException
     */
    T get(PK id) throws DaoException;

    /**
     * Persist the new instance object
     *
     * @throws DaoException
     */
    T add(T object) throws DaoException;

    /**
     * Save changes made to a transient object.
     *
     * @throws DaoException
     */
    void update(T object) throws DaoException;

    /**
     * Remove an object
     *
     * @throws DaoException
     */
    void delete(T object) throws DaoException;
    /**
     * Get all persisted objects by criterion
     * @param criterion
     * @return
     */
	List<T> getList(Criterion[] criterion) throws DaoException;
	/**
	 * Save or update 
	 * @param anketa
	 */
	void saveOrUpdate(T object) throws DaoException;
}

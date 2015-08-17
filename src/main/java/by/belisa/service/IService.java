package by.belisa.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

import by.belisa.exception.ServiceException;

public interface IService<T, PK extends Serializable> {

    List<T> getAll() throws ServiceException;
    List<T> getList(Criterion... criterion) throws ServiceException;
    T get(PK id) throws ServiceException;
    T add(T o) throws ServiceException;
    void update(T o) throws ServiceException;
    void delete(T o) throws ServiceException;


}

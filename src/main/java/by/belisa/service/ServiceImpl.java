package by.belisa.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.belisa.dao.Dao;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceErrorCode;
import by.belisa.exception.ServiceException;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ServiceImpl<T, PK extends Serializable> implements IService<T, PK> {

	private static Logger log = Logger.getLogger(ServiceImpl.class);
	private Class<T> type;
	protected String typeName;

	protected Dao<T, PK> baseDao;

	protected void setBaseDao(Dao<T, PK> baseDao) {
		this.baseDao = baseDao;
	}

	public ServiceImpl(Class<T> type) {
		this.type = type;
		this.typeName = type.getSimpleName();
		log.debug(String.format("Created Service for %s.", typeName));
	}

	public void setType(Class<T> type) {
		this.type = type;
		this.typeName = type.getSimpleName();
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<T> getAll() throws ServiceException {
		try {
			return baseDao.getAll();
		} catch (DaoException e) {
			throw new ServiceException(e, ServiceErrorCode.ERR_SRVC_005, typeName);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<T> getList(Criterion... criterion) throws ServiceException {
		try {
			return baseDao.getList(criterion);
		} catch (DaoException e) {
			throw new ServiceException(e, ServiceErrorCode.ERR_SRVC_001);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public T get(PK id) throws ServiceException {

		try {

			return baseDao.get(id);

		} catch (DaoException e) {

			throw new ServiceException(e, ServiceErrorCode.ERR_SRVC_002,
					typeName, id);
		}
	}

	public T add(T o) throws ServiceException {
		try {
			o = baseDao.add(o);
			return o;
		} catch (DaoException e) {
			throw new ServiceException(e, ServiceErrorCode.ERR_SRVC_000);
		}

	}

	public void update(T o) throws ServiceException {

		try {
			baseDao.update(o);

		} catch (DaoException e) {

			throw new ServiceException(e, ServiceErrorCode.ERR_SRVC_001,
					typeName);
		}
	}

	public void delete(T o) throws ServiceException {
		try {
			baseDao.delete(o);
		} catch (DaoException e) {
			throw new ServiceException(e, ServiceErrorCode.ERR_SRVC_004);
		}
	}

}

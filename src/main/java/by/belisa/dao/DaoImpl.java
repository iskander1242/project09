package by.belisa.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import by.belisa.exception.DaoException;

public class DaoImpl<T, PK extends Serializable> implements Dao<T, PK> {

	private static Logger log = Logger.getLogger(DaoImpl.class);
	@Qualifier("sessionFactory")
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> type;
	protected String typeName;

	public DaoImpl(Class<T> type) {
		this.type = type;
		this.typeName = type.getSimpleName();
		log.debug(String.format("Created Dao for %s.", typeName));
	}

	public void setType(Class<T> type) {
		this.type = type;
		this.typeName = type.getSimpleName();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		Session session =  sessionFactory.getCurrentSession();
		log.debug(String.format("Got current session for %s: %s.", typeName,
				session));
		return session;
	}

	

	@Override
	public List<T> getList(Criterion... criterion) throws DaoException {
		log.debug(String.format("Get list <%s>.", typeName));
		try {
			Criteria criteria = getSession().createCriteria(type);
			for (Criterion cr : criterion) {
				criteria.add(cr);
			}
			@SuppressWarnings("unchecked")
			List<T> list = criteria.list();
			log.debug(String.format("Got %d products",
					list == null ? 0 : list.size()));
			return list;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public T get(PK id) throws DaoException {
		try {
			log.debug(String.format("Get %s with id=%s.", typeName, id));
			@SuppressWarnings("unchecked")
			T o = (T) getSession().get(type, id);
			log.debug(String.format("Got %s: %s.", typeName, o));
			return o;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public T add(T o) throws DaoException {
		try {
			log.debug(String.format("Create %s: %s.", typeName, o));
			@SuppressWarnings("unchecked")
			PK id = (PK) getSession().save(o);
			getSession().flush();
			log.debug(String.format("Created %s with id=%s.", typeName, id));
			return get(id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void update(T o) throws DaoException {
		try {
			log.debug(String.format("Update %s: %s.", typeName, o));
			Session s = getSession();
			s.update(o);
			log.debug(String.format("Updated %s: %s.", typeName, o));
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void delete(T o) throws DaoException {
		try {
			log.debug(String.format("Delete %s: %s.", typeName, o));
			if (o != null) {
				getSession().delete(o);
				log.debug(String.format("Deleted %s: %s.", typeName, o));
			}
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void saveOrUpdate(T o) throws DaoException {
		try {
			log.debug(String.format("saveOrUpdate %s: %s.", typeName, o));
			Session s = getSession();
			s.saveOrUpdate(o);
			log.debug(String.format("Saved or Updated %s: %s.", typeName, o));
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
		
	}

	@Override
	public List<T> getAll() throws DaoException {
		log.debug(String.format("Get all <%s>.", typeName));
		try {
			@SuppressWarnings("unchecked")
			List<T> list = getSession().createCriteria(type)
					.addOrder(Order.asc("id")).list();
			log.debug(String.format("Got %d products",
					list == null ? 0 : list.size()));
			return list;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

}

package by.belisa.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import by.belisa.entity.Organization;
import by.belisa.exception.DaoException;
@Repository
public class OrgDao extends DaoImpl<Organization, Integer>{
	private static Logger log = Logger.getLogger(OrgDao.class);
	public OrgDao() {
		super(Organization.class);
	}
	@Override
	public List<Organization> getAll() throws DaoException {
		log.debug(String.format("Get all <%s>.", typeName));
		try {
			@SuppressWarnings("unchecked")
			List<Organization> list = getSession().createCriteria(Organization.class)
					.addOrder(Order.asc("name")).list();
			log.debug(String.format("Got %d products",
					list == null ? 0 : list.size()));
			return list;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	
}

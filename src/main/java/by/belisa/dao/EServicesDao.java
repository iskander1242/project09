package by.belisa.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import by.belisa.entity.Services;
import by.belisa.entitySqlServer.Res1;

@Repository
public class EServicesDao extends DaoImpl<Services, Integer>{

	public EServicesDao() {
		super(Services.class);
	}
	
	public List<Services> getAllbyPublication(Long pubblication){
//		Query q = getSession().createQuery("FROM Services WHERE publication=1");
		Criteria q = getSession().createCriteria(Services.class).add(
				Restrictions.sqlRestriction("upper({alias}.SHIFR) like upper(?)", "угр01%", Hibernate.STRING)
				);	
	    return q.list(); 
	}
}

package by.belisa.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import by.belisa.entity.Services;
import by.belisa.entitySqlServer.ResExt1;

@Repository
public class EServicesDao extends DaoImpl<Services, Integer>{

	public EServicesDao() {
		super(Services.class);
	}
	
	public List<Services> getAllbyPublication(Long pubblication){
//		Query q = getSession().createQuery("FROM Services WHERE publication=1");	
		Query q = getSession().createQuery("FROM Services");	
	    return q.list(); 
	}
}

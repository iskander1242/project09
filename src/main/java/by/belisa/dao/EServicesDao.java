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
	
/*	@SuppressWarnings("unchecked")
	public  void getExt(){
//		Query q = getSession().createQuery("FROM Services WHERE publication=1");	
		
		List<ResExt1>	result=
				(List<ResExt1>) getSession().createSQLQuery("exec dbo.Service01 @startdate='2015-01-01', @enddate='2015-06-30', @query=1")
				.addEntity(ResExt1.class).list();
		 
		 
//		 List<Res>	result=session.createQuery("from Res").list();	
	// session.createSQLQuery
		 List<Res> result =  (StoredProcedureOutput) session.createSQLQuery(
						"exec dbo.Service01ext @startdate='2015-01-01', @enddate='2015-06-30', @query=1").addEntity(Res.class).list();

		for (ResExt1 obj : result) {
		System.out.println(obj);
		}	
//	    return q.list(); 
	}*/

}

package by.belisa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;











import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;
















import by.belisa.entity.FileResult;
import by.belisa.entity.FileZapros;
import by.belisa.entity.Services;
import by.belisa.entity.Zapros;
import by.belisa.entitySqlServer.Res1;
import by.belisa.exception.DaoException;

@Repository
public class EServicesDao extends DaoImpl<Services, Integer>{

	public EServicesDao() {
		super(Services.class);
	}
	
	private static  Logger log=Logger.getLogger(EServicesDao.class);
	
	List listServises =null;
	
	public List<Services> getAllbyPublication(){
		 Criteria q = getSession().createCriteria(Services.class).add(
					Restrictions.sqlRestriction("publication=1 and info_system=1")					
					).addOrder(Order.asc("shifr"));
		//TODO
		setListServises(q.list());		
	    return q.list(); 
	}
	
	public void saveFile(Integer  userPk, byte[] fileStream, String fileName, String contentType, Integer fileSize, Long serviceId){	
		//System.err.println("fileStrea="+fileStream);
		System.err.println("Long serviceId"+serviceId);
		System.err.println("getFile(Services.class, serviceId)="+getFile(Services.class, serviceId));
		
		Session curSession =getSession();
		
		curSession.beginTransaction();
		
		Zapros zapros=new Zapros();
		 zapros.setServices(getFile(Services.class, serviceId));
		 zapros.setIdUser(userPk);
		 zapros.setStartDate(new Date());
		 zapros.setZapros("select 1 from dual");
		 
		 System.err.println("save="+curSession.save(zapros));
		 
	     FileZapros fileResult=new FileZapros();
		 fileResult.setZapros(zapros);
		 fileResult.setFileType(contentType);
		 fileResult.setFileName(fileName);
		 fileResult.setFileSize(fileSize);
		 //TODO replace  "ПРивет".getBytes()
		 fileResult.setDocuments(fileStream);
		 curSession.save(fileResult);
		 
		 curSession.getTransaction().commit();
		 curSession.close();
		 getAllResult(Zapros.class);
		 System.err.println("END");		 
	}

	public List<Services> getListServises() {
		return listServises;
	}

	public void setListServises(List<Services> list) {
		this.listServises = list;
	}
	
	/*public Services getCurService(Integer curId){
		//22	Предоставление специально оговоренных данных для обеспечения
		
			if (!getListServises().isEmpty()&&!(getListServises().get(0)==null)){
				return (Services) getListServises().get(0);
			} else {				
			    throw new NullPointerException("Database  sevice 22 is not exist");				    
			}
		}	
*/
	
	
	private  <T> void getAllResult(Class<T> classes) {
		Criteria q = getSession().createCriteria(classes);		
		 /*for (Object  i : q.list()){
			 System.out.println(((T)i));
		 }; */
	   System.err.println("q.list().size()="+q.list().size());	 
	}	
	public List<FileResult>  getAllFiles(Integer userPk, Long serviseID) {
		 //Long curService =  (long)53;
		 Criteria q = getSession().createCriteria(FileZapros.class,"f").add(Restrictions.sqlRestriction(
					"exists (select 1 from SERVICES.ZAPROS z where z.id = "
					+ "this_.id_zapros and z.id_user=? and z.id_service=?)",new Object[] {userPk,serviseID}
					,new Type[]{Hibernate.INTEGER,Hibernate.LONG}));
		 return q.list();
	}
	
	@SuppressWarnings("unchecked")
	public  <T> T getFile(Class<T> inClsss,Integer id) {
		T o = null;
		try {
			log.debug(String.format("Load %s with id=%s.", typeName, id));			
		    o = (T) getSession().load(inClsss, id);
			log.debug(String.format("Load %s: %s.", typeName, o));
			return o;
		} catch (HibernateException e) {
			System.err.println(e.getMessage());
		}		
		return o;
	}
	
	@SuppressWarnings("unchecked")
	public  <T> T getFile(Class<T> inClsss,Long id) {
		T o = null;
		try {
			log.debug(String.format("Load %s with id=%s.", typeName, id));			
		    o = (T) getSession().load(inClsss, id);
			log.debug(String.format("Load %s: %s.", typeName, o));
			return o;
		} catch (HibernateException e) {
			System.err.println(e.getMessage());
		}
		
		return o;
	}

	public <T> boolean delFile(Class<T> classType, Integer id) {
	try {				
			Object persistentInstance = getFile(classType, id);
		    if (persistentInstance != null) {		    	
		        Session curSession= getSession();		               
		        		curSession.delete(persistentInstance);		       
		        return true;
		        
		    }		   
		} catch (HibernateException e) {
			log.error(e.getMessage());
		}
	    return false;
	}
}

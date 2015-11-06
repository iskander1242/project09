package by.belisa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;




import by.belisa.entity.FileResult;
import by.belisa.entity.Services;
import by.belisa.entity.Zapros;
import by.belisa.entitySqlServer.Res1;

@Repository
public class EServicesDao extends DaoImpl<Services, Integer>{

	public EServicesDao() {
		super(Services.class);
	}
	
	List listServises =null;
	
	public List<Services> getAllbyPublication(){
		 Criteria q = getSession().createCriteria(Services.class).add(
					Restrictions.sqlRestriction("publication=1 and info_system='реестр'")
					);
		//TODO
		setListServises(q.list());		
	    return q.list(); 
	}
	
	public void saveFile(long  userPk, byte[] fileStream, String fileName, String contentType, long fileSize){	
		System.err.println("fileStrea="+fileStream);
		
		System.err.println(getCurService());
		
		Session curSession =getSession();
		
		curSession.beginTransaction();
		
		Zapros zapros=new Zapros();
		 zapros.setServices(getCurService());
		 zapros.setIdUser(11);
		 zapros.setStartDate(new Date());
		 zapros.setZapros("select 1 from dual");
		 
		 System.err.println("save="+curSession.save(zapros));
		 
	     FileResult fileResult=new FileResult();
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

	public List getListServises() {
		return listServises;
	}

	public void setListServises(List list) {
		this.listServises = list;
	}
	
	public Services getCurService(){
		//22	Предоставление специально оговоренных данных для обеспечения
		for(Services i: (ArrayList<Services>)getListServises()){
			if (i.getId()==22){
				return i;
			} else {
			    throw new NullPointerException("Database  sevice 22 is not exist");	
			}
		}		
		return  null;
	}
	
	
	private  <T> void getAllResult(Class<T> classes) {
		Criteria q = getSession().createCriteria(classes);		
		 /*for (Object  i : q.list()){
			 System.out.println(((T)i));
		 }; */
	   System.err.println("q.list().size()="+q.list().size());	 
	}
	
/*	return "FileResult [Id=" + Id + ", zapros=" + zapros 
			//+ ", documents="+ Arrays.toString(documents)
			+ ", description=" + description
			+ ", name=" + name + "]";*/
	
	public   ArrayList<FileResult>  getAllFiles() {
		ProjectionList projectionList= Projections.projectionList();
		projectionList.add(Projections.property("id"));
		projectionList.add(Projections.property("description"));
		projectionList.add(Projections.property("name"));
		Criteria q = getSession().createCriteria(FileResult.class)
				//.setProjection(projectionList)
				;			 
		 return (ArrayList<FileResult>) q.list(); 		
	}	
}

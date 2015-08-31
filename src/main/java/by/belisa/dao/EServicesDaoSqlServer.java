package by.belisa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import by.belisa.bean.ServiceData;
import by.belisa.entity.Services;
import by.belisa.entitySqlServer.ResExt1;
import by.belisa.entitySqlServer.ResExt2;
import by.belisa.entitySqlServer.ResExt3;
import by.belisa.entitySqlServer.ResExt4;
import by.belisa.entitySqlServer.ResExt5;
import by.belisa.entitySqlServer.ResExt6;
import by.belisa.entitySqlServer.ResExt7;

@Repository
public class EServicesDaoSqlServer extends DaoImplSec<Services, Integer>{
	
	

	
	

	public EServicesDaoSqlServer() {
		super(Services.class);
	}
	
	@SuppressWarnings("unchecked")
	public  ServiceData getExtRes1(){
		
	ServiceData serviceData=new ServiceData();
		
	List<ResExt1>	result1=(List<ResExt1>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='2015-01-01', @enddate='2015-06-30', @query=1")
				.addEntity(ResExt1.class).list();		
	List<ResExt2>	result2=
				(List<ResExt2>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='2015-01-01', @enddate='2015-06-30', @query=2")
				.addEntity(ResExt2.class).list(); 		
	List<ResExt3>	result3=
				(List<ResExt3>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='2015-01-01', @enddate='2015-06-30', @query=3")
				.addEntity(ResExt3.class).list();		
	List<ResExt4>	result4=
				(List<ResExt4>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='2015-01-01', @enddate='2015-06-30', @query=4")
				.addEntity(ResExt4.class).list();		
	List<ResExt5>	result5=
				(List<ResExt5>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='2015-01-01', @enddate='2015-06-30', @query=5")
				.addEntity(ResExt5.class).list(); 		
	List<ResExt6>	result6=
				(List<ResExt6>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='2015-01-01', @enddate='2015-06-30', @query=6")
				.addEntity(ResExt6.class).list();		
	List<ResExt7>	result7=
				(List<ResExt7>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='2015-01-01', @enddate='2015-06-30', @query=7")
				.addEntity(ResExt7.class).list(); 
	
	serviceData.setListRes1(result1);
	serviceData.setListRes2(result2);
	serviceData.setListRes3(result3);
	serviceData.setListRes4(result4);
	serviceData.setListRes5(result5);
	serviceData.setListRes6(result6);
	serviceData.setListRes7(result7);
	
	
	return serviceData;
	}
	
	

}
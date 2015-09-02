package by.belisa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import by.belisa.bean.ServiceData;
import by.belisa.bean.ServiceDataExt;
import by.belisa.entity.Services;
import by.belisa.entitySqlServer.Res1;
import by.belisa.entitySqlServer.Res2;
import by.belisa.entitySqlServer.Res3;
import by.belisa.entitySqlServer.Res4;
import by.belisa.entitySqlServer.Res5;
import by.belisa.entitySqlServer.Res6;
import by.belisa.entitySqlServer.Res7;
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
	public  ServiceData getRes(String dfrom, String dto){
		
	ServiceData serviceData=new ServiceData();
	
    /*	String dfrom ="2015-01-01";
	String dto ="2015-06-30";*/
		
	List<Res1>	result1=(List<Res1>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+dfrom+"', @enddate='"+dto+"', @query=1")
				.addEntity(Res1.class).list();		
	List<Res2>	result2=
				(List<Res2>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+dfrom+"', @enddate='"+dto+"', @query=2")
				.addEntity(Res2.class).list(); 		
	List<Res3>	result3=
				(List<Res3>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+dfrom+"', @enddate='"+dto+"', @query=3")
				.addEntity(Res3.class).list();		
	List<Res4>	result4=
				(List<Res4>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+dfrom+"', @enddate='"+dto+"', @query=4")
				.addEntity(Res4.class).list();		
	List<Res5>	result5=
				(List<Res5>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+dfrom+"', @enddate='"+dto+"', @query=5")
				.addEntity(Res5.class).list(); 		
	List<Res6>	result6=
				(List<Res6>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+dfrom+"', @enddate='"+dto+"', @query=6")
				.addEntity(Res6.class).list();		
	List<Res7>	result7=
				(List<Res7>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+dfrom+"', @enddate='"+dto+"', @query=7")
				.addEntity(Res7.class).list();	
	
	serviceData.setListRes1(result1);
	serviceData.setListRes2(result2);
	serviceData.setListRes3(result3);
	serviceData.setListRes4(result4);
	serviceData.setListRes5(result5);
	serviceData.setListRes6(result6);
	serviceData.setListRes7(result7);	
	
	return serviceData;
	}
	
	@SuppressWarnings("unchecked")
	public  ServiceDataExt getResExt(String dfrom, String dto){
		
	ServiceDataExt serviceData=new ServiceDataExt();
	
 /*   String dfrom ="2015-01-01";
	String dto ="2015-06-30";*/
		
	List<ResExt1>	result1=(List<ResExt1>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+dfrom+"', @enddate='"+dto+"', @query=1")
				.addEntity(ResExt1.class).list();
	
	/*for(ResExt1 i:result1){
		System.out.println(i);
	} */
	
	
	
	List<ResExt2>	result2=
				(List<ResExt2>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+dfrom+"', @enddate='"+dto+"', @query=2")
				.addEntity(ResExt2.class).list();
	
/*	for(ResExt2 i:result2){
		System.out.println(i);
	} */
	
	
	List<ResExt3>	result3=
				(List<ResExt3>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+dfrom+"', @enddate='"+dto+"', @query=3")
				.addEntity(ResExt3.class).list();
	
/*	for(ResExt3 i:result3){
		System.out.println(i);
	} */
	
	
	List<ResExt4>	result4=
				(List<ResExt4>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+dfrom+"', @enddate='"+dto+"', @query=4")
				.addEntity(ResExt4.class).list();
	
/*	for(ResExt4 i : result4){
		System.out.println(i);
	} */
	List<ResExt5>	result5=
				(List<ResExt5>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+dfrom+"', @enddate='"+dto+"', @query=5")
				.addEntity(ResExt5.class).list();
/*	for(ResExt5 i : result5){
		System.out.println(i);
	} */
	List<ResExt6>	result6=
				(List<ResExt6>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+dfrom+"', @enddate='"+dto+"', @query=6")
				.addEntity(ResExt6.class).list();
/*	for(ResExt6 i : result6){
		System.out.println(i);
	} */
	List<ResExt7>	result7=
				(List<ResExt7>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+dfrom+"', @enddate='"+dto+"', @query=7")
				.addEntity(ResExt7.class).list();
/*	for(ResExt7 i : result7){
		System.out.println(i);
	} */
	
	serviceData.setListResExt1(result1);
	serviceData.setListResExt2(result2);
	serviceData.setListResExt3(result3);
    serviceData.setListResExt4(result4);
    serviceData.setListResExt5(result5);
    serviceData.setListResExt6(result6);
	serviceData.setListResExt7(result7);
	
	return serviceData;
	}


	
	

}

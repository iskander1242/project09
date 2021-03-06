package by.belisa.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import by.belisa.bean.ServiceData;
import by.belisa.bean.ServiceDataExt;
import by.belisa.bean.ServiceDataNTD;
import by.belisa.entity.Services;
import by.belisa.entitySqlServer.Funding;
import by.belisa.entitySqlServer.Res1;
import by.belisa.entitySqlServer.Res11;
import by.belisa.entitySqlServer.Res2;
import by.belisa.entitySqlServer.Res21;
import by.belisa.entitySqlServer.Res3;
import by.belisa.entitySqlServer.Res31;
import by.belisa.entitySqlServer.Res4;
import by.belisa.entitySqlServer.Res41;
import by.belisa.entitySqlServer.Res5;
import by.belisa.entitySqlServer.Res51;
import by.belisa.entitySqlServer.Res6;
import by.belisa.entitySqlServer.Res61;
import by.belisa.entitySqlServer.Res7;
import by.belisa.entitySqlServer.Res71;
import by.belisa.entitySqlServer.ResExt1;
import by.belisa.entitySqlServer.ResExt2;
import by.belisa.entitySqlServer.ResExt3;
import by.belisa.entitySqlServer.ResExt4;
import by.belisa.entitySqlServer.ResExt5;
import by.belisa.entitySqlServer.ResExt6;
import by.belisa.entitySqlServer.ResExt7;
import by.belisa.entitySqlServer.ResultNTI;

@Repository
public class EServicesDaoSqlServer extends DaoImplSec<Services, Integer>{
	
	

	
	

	public EServicesDaoSqlServer() {
		super(Services.class);
	}
	
	@SuppressWarnings("unchecked")
	public  ServiceData getRes(String dfrom, String dto) throws ParseException{
		
	ServiceData serviceData=new ServiceData();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
	Date d = sdf.parse(dfrom);
	String newDateString = new SimpleDateFormat("yyyy-mm-dd").format(d);
	
	System.out.println(newDateString);
	
	
	Date endDate = sdf.parse(dto);
	String end = new SimpleDateFormat("yyyy-mm-dd").format(endDate);
	System.out.println(end);
	
/*   	String dfrom ="2015-01-01";
	String dto ="2015-06-30";*/
		
	List<Res11>	result1=(List<Res11>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+newDateString+"', @enddate='"+end+"', @query=1")
				.addEntity(Res11.class).list();		
	List<Res21>	result2=
				(List<Res21>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+newDateString+"', @enddate='"+end+"', @query=2")
				.addEntity(Res21.class).list(); 		
	List<Res31>	result3=
				(List<Res31>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+newDateString+"', @enddate='"+end+"', @query=3")
				.addEntity(Res31.class).list();		
	List<Res41>	result4=
				(List<Res41>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+newDateString+"', @enddate='"+end+"', @query=4")
				.addEntity(Res41.class).list();		
	List<Res51>	result5=
				(List<Res51>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+newDateString+"', @enddate='"+end+"', @query=5")
				.addEntity(Res51.class).list(); 		
	List<Res61>	result6=
				(List<Res61>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+newDateString+"', @enddate='"+end+"', @query=6")
				.addEntity(Res61.class).list();		
	List<Res71>	result7=
				(List<Res71>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01 @startdate='"+newDateString+"', @enddate='"+end+"', @query=7")
				.addEntity(Res71.class).list();	
	
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
	public  ServiceDataExt getResExt(String dfrom, String dto) throws ParseException{
		
	ServiceDataExt serviceDataExt=new ServiceDataExt();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
	Date d = sdf.parse(dfrom);
	sdf.applyPattern("yyyy-mm-dd");
	String newDateString = sdf.format(d);	
	
	
	Date endDate = sdf.parse(dto);
	sdf.applyPattern("yyyy-mm-dd");
	String end = sdf.format(endDate);
	
 /*   String dfrom ="2015-01-01";
	String dto ="2015-06-30";*/
		
	List<ResExt1>	result1=(List<ResExt1>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+newDateString+"', @enddate='"+end+"', @query=1")
				.addEntity(ResExt1.class).list();
	
	/*for(ResExt1 i:result1){
		System.out.println(i);
	} */	
	
	
	List<ResExt2>	result2=
				(List<ResExt2>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+newDateString+"', @enddate='"+end+"', @query=2")
				.addEntity(ResExt2.class).list();
	
/*	for(ResExt2 i:result2){
		System.out.println(i);
	} */	
	
	List<ResExt3>	result3=
				(List<ResExt3>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+newDateString+"', @enddate='"+end+"', @query=3")
				.addEntity(ResExt3.class).list();
	
/*	for(ResExt3 i:result3){
		System.out.println(i);
	} */	
	
	List<ResExt4>	result4=
				(List<ResExt4>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+newDateString+"', @enddate='"+end+"', @query=4")
				.addEntity(ResExt4.class).list();
	
/*	for(ResExt4 i : result4){
		System.out.println(i);
	} */
	List<ResExt5>	result5=
				(List<ResExt5>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+newDateString+"', @enddate='"+end+"', @query=5")
				.addEntity(ResExt5.class).list();
/*	for(ResExt5 i : result5){
		System.out.println(i);
	} */
	List<ResExt6>	result6=
				(List<ResExt6>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+newDateString+"', @enddate='"+end+"', @query=6")
				.addEntity(ResExt6.class).list();
/*	for(ResExt6 i : result6){
		System.out.println(i);
	} */
	List<ResExt7>	result7=
				(List<ResExt7>) getSession().createSQLQuery("exec ServiceGR.dbo.Service01ext @startdate='"+newDateString+"', @enddate='"+end+"', @query=7")
				.addEntity(ResExt7.class).list();
/*	for(ResExt7 i : result7){
		System.out.println(i);
	} */
	
	serviceDataExt.setListResExt1(result1);
	serviceDataExt.setListResExt2(result2);
	serviceDataExt.setListResExt3(result3);
    serviceDataExt.setListResExt4(result4);
    serviceDataExt.setListResExt5(result5);
    serviceDataExt.setListResExt6(result6);
	serviceDataExt.setListResExt7(result7);
	
	return serviceDataExt;
	}
	
	
	@SuppressWarnings("unchecked")
	public  ServiceDataNTD getResNTD(String num){
	
/*	String num1="20102010";	*/	
		
	ServiceDataNTD serviceDataNTD =new ServiceDataNTD();
		
	List<Funding>	fundingList=(List<Funding>) getSession().createSQLQuery("exec dbo.Service02 @projectid='"+num+"',  @query=2")
				.addEntity(Funding.class).list();
	
/*	for(Funding i : fundingList){
		System.out.println(i);
	}*/
	
	List<ResultNTI>	resultNTIList=(List<ResultNTI>) getSession().createSQLQuery("exec dbo.Service02 @projectid='"+num+"',  @query=1")
				.addEntity(ResultNTI.class).list();		
	

/*	for(ResultNTI i : resultNTIList){
		System.out.println(i);
	}*/
	

	serviceDataNTD.setResultNTIList(resultNTIList);
	serviceDataNTD.setFundingList(fundingList);
	serviceDataNTD.setCopyResultNTIList(resultNTIList);
	return serviceDataNTD;
	}


	
	

}

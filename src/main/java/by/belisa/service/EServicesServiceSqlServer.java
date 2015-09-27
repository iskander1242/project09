package by.belisa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.belisa.bean.ServiceData;
import by.belisa.bean.ServiceDataExt;
import by.belisa.bean.ServiceDataNTD;
import by.belisa.dao.Dao;
import by.belisa.dao.EServicesDao;
import by.belisa.dao.EServicesDaoSqlServer;
import by.belisa.dao.NewsDao;
import by.belisa.entity.NewTech;
import by.belisa.entity.News;
import by.belisa.entity.Services;

@Service
public class EServicesServiceSqlServer extends ServiceImpl<Services, Integer>{
	
	public EServicesServiceSqlServer() {
		super(Services.class);
	}	

	@Override
	@Autowired
	@Qualifier("eServicesDaoSqlServer")
	protected void setBaseDao(Dao<Services, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceData getService01Res(String dfrom, String dto){
		 return ((EServicesDaoSqlServer)baseDao).getRes(dfrom, dto);
	}
    
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceDataExt getService01ResExt(String dfrom, String dto){
		 return ((EServicesDaoSqlServer)baseDao).getResExt(dfrom, dto);
	}
    
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
   	public ServiceDataNTD getService02(String num){
   		 return ((EServicesDaoSqlServer)baseDao).getResNTD(num);
   	}
}

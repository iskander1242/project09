package by.belisa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.belisa.dao.Dao;
import by.belisa.dao.EServicesDao;
import by.belisa.dao.EServicesDaoSqlServer;
import by.belisa.dao.NewsDao;
import by.belisa.entity.NewTech;
import by.belisa.entity.News;
import by.belisa.entity.Services;

@Service
public class EServicesServiceOracle extends ServiceImpl<Services, Integer>{

	private Dao<Services, Integer> sqlServerDao;
	
	public EServicesServiceOracle() {
		super(Services.class);
	}
	
	

	@Override
	@Autowired
	@Qualifier("eServicesDao")
	protected void setBaseDao(Dao<Services, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	


/*	@Autowired
	@Qualifier("eServicesDaoSqlServer")
	protected void setSqlServerDao(Dao<Services, Integer> sqlServerDao) {
		this.sqlServerDao=sqlServerDao;
	}*/
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Services> getAllbyPublication(long publication){
		return ((EServicesDao)baseDao).getAllbyPublication(new Long(1));
	}
	
/*	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void getExt(){
		 ((EServicesDaoSqlServer)sqlServerDao).getExt();;
	}*/

}

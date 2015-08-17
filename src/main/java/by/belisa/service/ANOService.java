package by.belisa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.belisa.dao.ANODao;
import by.belisa.dao.Dao;
import by.belisa.entity.ANO;

@Service(value="ANOService")
public class ANOService extends ServiceImpl<ANO, Integer>{

	public ANOService() {
		super(ANO.class);
	}

	@Override
	@Autowired
	@Qualifier(value="ANODao")
	protected void setBaseDao(Dao<ANO, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ANO> getActualAno(){
		return ((ANODao)baseDao).getActualANO();
	}
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ANO> getExcludedAno(){
		return ((ANODao)baseDao).getExcludedANO();
	}
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ANO> getRequestAno(){
		return ((ANODao)baseDao).getRequestANO();
	}
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ANO getOrgByUnp(String unp){
		return ((ANODao)baseDao).getOrgByUnp(unp);
	}

}

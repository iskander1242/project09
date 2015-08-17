package by.belisa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.belisa.dao.Dao;
import by.belisa.dao.SIIDao;
import by.belisa.entity.SII;

@Service(value="SIIService")
public class SIIService extends ServiceImpl<SII, Integer>{

	public SIIService() {
		super(SII.class);
	}

	@Override
	@Autowired
	@Qualifier(value="SIIDao")
	protected void setBaseDao(Dao<SII, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SII> getActualSubjects(){
		return ((SIIDao)baseDao).getActualSubjects();
	}
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SII> getExcludedSubjects(){
		return ((SIIDao)baseDao).getExcludedSubjects();
	}
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SII> getRequestSubjects(){
		return ((SIIDao)baseDao).getRequestSubjects();
	}
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SII getSubjectByUnp(String unp){
		return ((SIIDao)baseDao).getSubjectByUnp(unp);
	}
}

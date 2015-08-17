package by.belisa.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import by.belisa.entity.SII;
@Repository(value="SIIDao")
public class SIIDao extends DaoImpl<SII, Integer>{

	public SIIDao() {
		super(SII.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<SII> getActualSubjects(){
		return getSession().createCriteria(SII.class)
		.add(Restrictions.isNull("rezident"))
		.add(Restrictions.eq("priznak", 1))
		.list();
	}
	@SuppressWarnings("unchecked")
	public List<SII> getExcludedSubjects(){
		return getSession().createCriteria(SII.class)
		.add(Restrictions.isNull("rezident"))
		.add(Restrictions.eq("priznak", 2))
		.list();
	}
	@SuppressWarnings("unchecked")
	public List<SII> getRequestSubjects(){
		return getSession().createCriteria(SII.class)
		.add(Restrictions.isNull("rezident"))
		.add(Restrictions.eq("priznak", 3))
		.list();
	}
	
	public SII getSubjectByUnp(String unp){
		return (SII) getSession().createCriteria(SII.class)
		.add(Restrictions.isNull("rezident"))
		.createAlias("subject", "sbj")
		 .add(Restrictions.eq("sbj.unp", unp))
		.uniqueResult();
	}

}

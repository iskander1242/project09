package by.belisa.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import by.belisa.entity.ANO;

@Repository(value="ANODao")
public class ANODao extends DaoImpl<ANO, Integer>{

	public ANODao() {
		super(ANO.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<ANO> getActualANO(){
		return getSession().createCriteria(ANO.class)
				.add(Restrictions.eq("priznak", 1))
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ANO> getRequestANO(){
		return getSession().createCriteria(ANO.class)
				.add(Restrictions.eq("priznak", 3))
				.list();
	}
	@SuppressWarnings("unchecked")
	public List<ANO> getExcludedANO(){
		return getSession().createCriteria(ANO.class)
				.add(Restrictions.eq("priznak", 2))
				.list();
	}
	
	public ANO getOrgByUnp(String unp){
		return (ANO) getSession().createCriteria(ANO.class)
		.createAlias("org", "org")
    	.add(Restrictions.eq("org.unp", unp))
		.uniqueResult();
	}

}

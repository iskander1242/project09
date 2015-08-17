package by.belisa.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import by.belisa.entity.GirProducts;

@Repository
public class GirProductsDao extends DaoImpl<GirProducts, Integer>{

	public GirProductsDao() {
		super(GirProducts.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<GirProducts> getActualVTT(){
		return getSession().createCriteria(GirProducts.class)
				.add(Restrictions.eq("priznak", 1))
				.list();
	}
	@SuppressWarnings("unchecked")
	public List<GirProducts> getRequestVTT(){
		return getSession().createCriteria(GirProducts.class)
				.add(Restrictions.eq("priznak", 3))
				.list();
	}

}

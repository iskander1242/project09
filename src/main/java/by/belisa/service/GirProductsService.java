package by.belisa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.belisa.dao.Dao;
import by.belisa.dao.GirProductsDao;
import by.belisa.entity.GirProducts;

@Service
public class GirProductsService extends ServiceImpl<GirProducts, Integer>{

	public GirProductsService() {
		super(GirProducts.class);
	}

	@Override
	@Autowired
	@Qualifier(value="girProductsDao")
	protected void setBaseDao(Dao<GirProducts, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<GirProducts> getActualVTT(){
		return ((GirProductsDao)baseDao).getActualVTT();
	}
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<GirProducts> getRequestVTT(){
		return ((GirProductsDao)baseDao).getRequestVTT();
	}

}

package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.GirIntd;

@Service
public class GirIntdService extends ServiceImpl<GirIntd, Integer>{

	public GirIntdService() {
		super(GirIntd.class);
	}

	@Override
	@Autowired
	@Qualifier(value="girIntdDao")
	protected void setBaseDao(Dao<GirIntd, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}

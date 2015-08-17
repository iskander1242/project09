	package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.UchStepeni;
@Service
public class UchStepeniService extends ServiceImpl<UchStepeni, Integer>{

	public UchStepeniService() {
		super(UchStepeni.class);
	}

	@Override
	@Autowired
	@Qualifier("uchStepeniDao")
	protected void setBaseDao(Dao<UchStepeni, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
}

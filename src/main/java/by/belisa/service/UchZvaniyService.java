package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.UchZvaniy;
@Service
public class UchZvaniyService extends ServiceImpl<UchZvaniy, Integer>{

	public UchZvaniyService() {
		super(UchZvaniy.class);
	}
	
	@Override
	@Autowired
	@Qualifier("uchZvanieDao")
	protected void setBaseDao(Dao<UchZvaniy, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}

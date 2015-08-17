package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.NewTech;

@Service
public class NewTechService extends ServiceImpl<NewTech, Integer>{

	public NewTechService() {
		super(NewTech.class);
	}

	@Override
	@Autowired
    @Qualifier("newTechDao")
	protected void setBaseDao(Dao<NewTech, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}

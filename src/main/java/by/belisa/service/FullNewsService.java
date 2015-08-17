package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.FullNews;

@Service
public class FullNewsService extends ServiceImpl<FullNews, Integer>{

	public FullNewsService() {
		super(FullNews.class);
	}

	@Override
	@Autowired
	@Qualifier(value="fullNewsDao")
	protected void setBaseDao(Dao<FullNews, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

}

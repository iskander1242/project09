package by.belisa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.belisa.dao.Dao;
import by.belisa.dao.NewsDao;
import by.belisa.entity.News;

@Service
public class NewsService extends ServiceImpl<News, Integer>{

	public NewsService() {
		super(News.class);
	}

	@Override
	@Autowired
	@Qualifier(value="newsDao")
	protected void setBaseDao(Dao<News, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<News> list(int page,int count){
		return ((NewsDao)baseDao).list(page, count);
	}
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long listSize(){
		return ((NewsDao)baseDao).listSize();
	}

}

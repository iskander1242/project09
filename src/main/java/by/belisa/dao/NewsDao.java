package by.belisa.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import by.belisa.entity.News;

@Repository
public class NewsDao extends DaoImpl<News, Integer>{

	public NewsDao() {
		super(News.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<News> list(int page, int count){
		Query q = getSession().createQuery("FROM News WHERE publication=true ORDER BY date DESC");
	    q.setFirstResult((page-1)*count);
	    q.setMaxResults(count);
	    return q.list();
	}
	
	public long listSize(){
		return (long) getSession().createQuery("SELECT COUNT(*) FROM News WHERE publication=true").uniqueResult();
	}

}

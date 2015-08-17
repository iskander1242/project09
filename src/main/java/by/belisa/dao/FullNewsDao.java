package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.FullNews;

@Repository
public class FullNewsDao extends DaoImpl<FullNews, Integer>{

	public FullNewsDao() {
		super(FullNews.class);
	}

}

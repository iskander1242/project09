package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.Okogu;
@Repository
public class OkoguDao extends DaoImpl<Okogu, Integer>{

	public OkoguDao() {
		super(Okogu.class);
		// TODO Auto-generated constructor stub
	}

}

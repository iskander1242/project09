package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.UchZvaniy;
@Repository
public class UchZvanieDao extends DaoImpl<UchZvaniy, Integer>{

	public UchZvanieDao() {
		super(UchZvaniy.class);
	}

}

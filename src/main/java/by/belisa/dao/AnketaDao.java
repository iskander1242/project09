package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.Anketa;
@Repository
public class AnketaDao extends DaoImpl<Anketa, Long>{

	public AnketaDao() {
		super(Anketa.class);
	}

}

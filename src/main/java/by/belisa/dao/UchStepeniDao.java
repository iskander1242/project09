package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.UchStepeni;
@Repository
public class UchStepeniDao extends DaoImpl<UchStepeni, Integer>{

	public UchStepeniDao() {
		super(UchStepeni.class);
	}

}

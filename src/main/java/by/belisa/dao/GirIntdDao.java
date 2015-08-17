package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.GirIntd;

@Repository
public class GirIntdDao extends DaoImpl<GirIntd, Integer>{

	public GirIntdDao() {
		super(GirIntd.class);
	}

}

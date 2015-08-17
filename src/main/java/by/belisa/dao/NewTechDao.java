package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.NewTech;

@Repository
public class NewTechDao extends DaoImpl<NewTech, Integer>{

	public NewTechDao() {
		super(NewTech.class);
	}

}

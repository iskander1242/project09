package by.belisa.dao;

import org.springframework.stereotype.Repository;

import by.belisa.entity.VidOrg;
@Repository
public class VidOrgDao extends DaoImpl<VidOrg, Integer>{

	public VidOrgDao() {
		super(VidOrg.class);
	}

}

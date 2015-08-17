package by.belisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.dao.Dao;
import by.belisa.entity.VidOrg;
@Service
public class VidOrgService extends ServiceImpl<VidOrg, Integer>{

	public VidOrgService() {
		super(VidOrg.class);
	}

	@Override
	@Autowired
	@Qualifier("vidOrgDao")
	protected void setBaseDao(Dao<VidOrg, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
}

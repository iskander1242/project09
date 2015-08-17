package by.belisa.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.OrgDTO;
import by.belisa.dao.Dao;
import by.belisa.dao.OkoguDao;
import by.belisa.dao.VidOrgDao;
import by.belisa.entity.Organization;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;

@Service
public class OrgService extends ServiceImpl<Organization, Integer> {

	public OrgService() {
		super(Organization.class);
	}

	@Autowired
	@Qualifier("okoguDao")
	private OkoguDao okoguDao;

	

	@Autowired
	@Qualifier("vidOrgDao")
	private VidOrgDao vidOrgDao;

	@Override
	@Autowired
	@Qualifier("orgDao")
	protected void setBaseDao(Dao<Organization, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}

	public void saveOrUpdate(OrgDTO orgDTO) throws ParseException, DaoException, ServiceException {
		Organization org = new Organization();
		org.setAddress(orgDTO.getAddress());
		org.setCodeBooker(orgDTO.getKod_booker());
		org.setEmail(orgDTO.getEmail());
		org.setFullNameE(orgDTO.getFull_name_eng());
		org.setFullNameR(orgDTO.getFull_name_rus());
		org.setName(orgDTO.getName());
		if (orgDTO.getOkoguName() != null)
			org.setOkogu(okoguDao.get(orgDTO.getOkoguId()));
		org.setOldCode(orgDTO.getKod_old());
		org.setUnp(orgDTO.getUnp());
		if (orgDTO.getVidOrgId() != null)
			org.setVidOrg(vidOrgDao.get(orgDTO.getVidOrgId()));
		baseDao.saveOrUpdate(org);
	}

	public OrgDTO getOrgDTOById(Integer id) throws DaoException {
		return new OrgDTO(baseDao.get(id));
	}



}

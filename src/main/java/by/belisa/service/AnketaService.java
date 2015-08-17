package by.belisa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.belisa.bean.AnketaDTO;
import by.belisa.dao.Dao;
import by.belisa.dao.OrgDao;
import by.belisa.dao.UchStepeniDao;
import by.belisa.dao.UchZvanieDao;
import by.belisa.dao.UserDao;
import by.belisa.entity.Anketa;
import by.belisa.entity.UchStepeni;
import by.belisa.entity.UchZvaniy;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
@Service
public class AnketaService extends ServiceImpl<Anketa,Long>{
	
	public AnketaService() {
		super(Anketa.class);
	}
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	@Autowired
	@Qualifier("uchStepeniDao")
	private UchStepeniDao uchStepeniDao;
	@Autowired
	@Qualifier("uchZvanieDao")
	private UchZvanieDao uchZvanieDao;
	@Autowired
	@Qualifier("orgDao")
	private OrgDao orgDao;

	@Override
	@Autowired
	@Qualifier("anketaDao")
	protected void setBaseDao(Dao<Anketa, Long> baseDao) {
		super.setBaseDao(baseDao);
	}
	public Anketa checkUser(User user) throws DaoException, PortalException, SystemException{
		Anketa anketa = baseDao.get(user.getUserId());
		if (anketa==null){
			anketa = new Anketa();
			anketa.setBirthday(user.getBirthday());
			anketa.setEmail(user.getEmailAddress());
			anketa.setFullFio(user.getLastName() + " "
					+ user.getFirstName() + " " + user.getMiddleName());
			anketa.setFio(user.getLastName() + " "
					+ user.getFirstName().charAt(0) + "."
					+ user.getMiddleName().charAt(0) + ".");
			anketa.setName(user.getFirstName());
			anketa.setSurname(user.getLastName());
			anketa.setPatronymic(user.getMiddleName());
			anketa.setUser(userDao.get(user.getUserId()));
			anketa = baseDao.add(anketa);
		}
		return anketa;
	}
	public void saveOrUpdate(AnketaDTO anketaDTO) throws ParseException, DaoException, ServiceException{
		Anketa anketa = baseDao.get(anketaDTO.getId());
		 if (anketa==null){
			 anketa = new Anketa();
		 }
		anketa.setAddress(anketaDTO.getAddress());
		anketa.setBiography(anketaDTO.getBiography());
		if (anketaDTO.getBirthday()!=null && !anketaDTO.getBirthday().isEmpty()){
			anketa.setBirthday(dateFormat.parse(anketaDTO.getBirthday()));
		}
		anketa.setName(anketaDTO.getName());
		anketa.setSurname(anketaDTO.getSurname());
		anketa.setPatronymic(anketaDTO.getPatronymic());
		
		anketa.setEmail(anketaDTO.getEmail());
		anketa.setFio(anketaDTO.getFio());
		anketa.setFullFio(anketaDTO.getFullFio());
		anketa.setHomePhone(anketaDTO.getHomePhone());
		anketa.setJobPhone(anketaDTO.getJobPhone());
		anketa.setLab(anketaDTO.getLab());
		anketa.setMobilePhone(anketaDTO.getMobilePhone());
		if (anketaDTO.getOrgId()!=null)
		anketa.setOrg(orgDao.get(anketaDTO.getOrgId()));
		anketa.setPost(anketaDTO.getPost());
		List<UchZvaniy> uchZvaniyList = new ArrayList<UchZvaniy>();
		if (anketaDTO.getUchZvaniyIdArr()!=null){
			for (Integer i : anketaDTO.getUchZvaniyIdArr()){
				uchZvaniyList.add(uchZvanieDao.get(i));
			}
		}
		anketa.setUchZvaniyList(uchZvaniyList);
		List<UchStepeni> uchStepeniList = new ArrayList<UchStepeni>();
		if (anketaDTO.getUchStepeniIdArr()!=null){
			for (Integer i : anketaDTO.getUchStepeniIdArr()){
				uchStepeniList.add(uchStepeniDao.get(i));
			}
		}
		anketa.setUchStepeniList(uchStepeniList);
		anketa.setUser(userDao.get(anketaDTO.getId()));
		baseDao.saveOrUpdate(anketa);
	}
	
	public AnketaDTO getDTO(Long id) throws DaoException{
		Anketa anketa = baseDao.get(id);
		AnketaDTO anketaDTO = new AnketaDTO(anketa);
		return anketaDTO;
		
	}
	
	

}

package by.belisa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.belisa.dao.Dao;
import by.belisa.dao.EServicesDao;
import by.belisa.dao.EServicesDaoSqlServer;
import by.belisa.dao.NewsDao;
import by.belisa.entity.FileResult;
import by.belisa.entity.FileZapros;
import by.belisa.entity.NewTech;
import by.belisa.entity.News;
import by.belisa.entity.Services;

@Service
public class EServicesServiceOracle extends ServiceImpl<Services, Integer>{

	private Dao<Services, Integer> sqlServerDao;
	
	public EServicesServiceOracle() {
		super(Services.class);
	}
	

	@Override
	@Autowired
	@Qualifier("eServicesDao")
	protected void setBaseDao(Dao<Services, Integer> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Services> getAllbyPublication(){
		return ((EServicesDao)baseDao).getAllbyPublication();
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void saveFile(Integer userPk,byte[] fileStream, String fileName, String contentType, Integer size, Long serviceId){
		((EServicesDao)baseDao).saveFile(userPk, fileStream,fileName,contentType,size,serviceId);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FileResult> getAllFile(Integer integer, long serviseID){
		return  ((EServicesDao)baseDao).getAllFiles(integer,serviseID);
	}

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FileZapros getFile(Class<FileZapros> fileClass, Integer id) {
			return ((EServicesDao)baseDao).getFile(fileClass, id);
	}
    

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public boolean delFile(Class<FileZapros> fileClass, Integer id) {
			return ((EServicesDao)baseDao).delFile(fileClass, id);
	}
	
}

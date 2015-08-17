package by.belisa.dao;

import static junit.framework.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ano-portlet.xml")
@TransactionConfiguration
@Transactional
@Ignore
public class ANODaoTest {
	@Autowired
	private ANODao anoDao;
	
	@Test
	public void testGetActualAno(){
		assertEquals(188, anoDao.getActualANO().size());
	}

	@Test
	public void testGetOrgByUnp(){
		assertNotNull(anoDao.getOrgByUnp("100050710"));
		assertNull(anoDao.getOrgByUnp("190635919"));
	}
}

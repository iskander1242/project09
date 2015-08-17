package by.belisa.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:sii-portlet.xml")
@TransactionConfiguration
@Transactional
@Ignore
public class SIIDaoTest {
	
	@Autowired
	@Qualifier(value="SIIDao")
	private SIIDao siiDao;
	
	@Test
	public void testGetSubjects(){
		assertEquals(18, siiDao.getActualSubjects().size()); 
	}
	@Test
	public void testGetSubjectByUnp(){
		assertNotNull(siiDao.getSubjectByUnp("101556208"));
		assertNull(siiDao.getSubjectByUnp("qwe"));
	}

}

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

import by.belisa.exception.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:news-portlet.xml")
@TransactionConfiguration
@Transactional
@Ignore
public class NewsDaoTest {
	
	@Autowired
	@Qualifier(value="newsDao")
	private NewsDao newsDao;
	@Autowired
	@Qualifier(value="fullNewsDao")
	private FullNewsDao fullNewsDao;
	
	@Test
	public void testGetNewsById() throws DaoException{
		assertNotNull(newsDao.get(2452)); 
	}
	@Test
	public void testGetFullNewsById() throws DaoException{
		assertNotNull(fullNewsDao.get(2452)); 
	}
}

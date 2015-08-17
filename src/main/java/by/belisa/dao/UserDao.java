package by.belisa.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import by.belisa.entity.User;

@Repository
public class UserDao extends DaoImpl<User, Long> {
	private static Logger log = Logger.getLogger(UserDao.class);

	public UserDao() {
		super(User.class);
	}
	
}

package app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.service.impl.UserServiceImpl;

import app.dao.UserDAO;
import app.model.User;

import app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User findByUsenameAndPassword(String username, String password) {
		try {
			User user = userDAO.findByUsenameAndPassword(username, password);
			return user;
		} catch (Exception e) {
			LOGGER.info("---> Error find username and password");
			return null;
		}
	}

}

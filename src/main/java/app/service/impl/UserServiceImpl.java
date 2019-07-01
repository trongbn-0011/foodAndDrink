package app.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;

import app.model.User;
import app.service.UserService;

public class UserServiceImpl extends BaseServiceImpl implements UserService {
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	@Override
	public User findById(Serializable key) {
		try {
			return getUserDAO().findById(key);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public User saveOrUpdate(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(User entity) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public boolean createUser(User user) {
		try {
			user.setActived(0);
			user.setRole(0);
			User userNew = getUserDAO().saveOrUpdate(user);
			return userNew != null;
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return false;
	}

}

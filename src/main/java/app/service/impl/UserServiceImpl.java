package app.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
	public User findByEmailAndPassword(String usermail, String password) {
		try {
			User user = userDAO.findByEmailAndPassword(usermail, password);
			return user;
		} catch (Exception e) {
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
			throw e;
		}

	}

	@Override
	public boolean isEmailExist(String email) {
		try {
			return getUserDAO().checkEmail(email);
		} catch (Exception e) {
			LOGGER.error(e);
			throw e;
		}
	}

	public Page<User> findPaginated(Pageable pageable, List<User> users, String userName) {
		try {
			Page<User> userPage = new PageImpl<User>(users,
					PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), userCount(userName));
			return userPage;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int userCount(String userName) {
		try {
			return getUserDAO().userCount(userName);
		} catch (Exception e) {
			LOGGER.error(e);
			throw e;
		}
	}

	@Override
	public Page<User> loadUsers(String userName, Pageable pageable) {
		try {
			List<User> users = getUserDAO().loadUsers(userName, pageable.getPageSize(), pageable.getPageNumber());
			return findPaginated(pageable, users, userName);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

}

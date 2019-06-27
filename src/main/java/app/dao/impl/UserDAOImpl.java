package app.dao.impl;

import app.dao.GenericDAO;
import app.dao.UserDAO;
import app.model.User;

public class UserDAOImpl extends GenericDAO<Integer, User> implements UserDAO {
	
	public UserDAOImpl() {
		super(User.class);
	}

	@Override
	public User findByUsenameAndPassword(String username, String password) {
		return (User) getSession().createQuery("from User where name=:username and password=:password")
				.setParameter("username", username).setParameter("password", password).uniqueResult();
	}
}

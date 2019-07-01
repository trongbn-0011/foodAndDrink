package app.dao;

import app.model.User;

public interface UserDAO extends BaseDAO<Integer, User> {

	User findByUsenameAndPassword(String username, String password);

	boolean checkEmail(String email);
	
}

package app.service;

import app.model.User;

public interface UserService extends BaseService<Integer, User> {
	
	User findByUsenameAndPassword(String username, String password);
	
}

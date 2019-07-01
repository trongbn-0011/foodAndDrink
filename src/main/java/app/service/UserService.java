package app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import app.model.User;

public interface UserService extends BaseService<Integer, User> {
	
	User findByUsenameAndPassword(String username, String password);
	
	boolean createUser(User user);

	Page<User> loadUsers(String userName, Pageable pageable);
	
	int userCount(String userName);
	
}

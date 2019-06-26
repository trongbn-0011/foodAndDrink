package app.service;

import app.model.User;

public interface UserService {

	User findByUsenameAndPassword(String username, String password);

}

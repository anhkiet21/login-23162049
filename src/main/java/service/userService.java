package service;

import model.user;

public interface userService {
	user login(String username, String password);

	user get(String username);

	void insert(user User);

	boolean register(String email, String password, String username);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

}

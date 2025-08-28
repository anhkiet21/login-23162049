package service;

import model.user;

public interface userService {
	user login(String username,String password);
	user get(String username);
}

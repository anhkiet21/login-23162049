package service;

import model.user;

public interface userDao {
	user get(String username);

	void insert(user User);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

}

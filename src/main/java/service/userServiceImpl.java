package service;

import model.user;

public class userServiceImpl implements userService {
	userDao UserDao = new userDaoImpl();

	public user login(String username, String password) {
		user User = this.get(username);
		if (User != null && password.equals(User.getPassword())) {
			return User;
		}
		return null;
	}

	public user get(String username) {
		return UserDao.get(username);
	}

	@Override
	public boolean register(String username, String password, String email) {
		if (UserDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		UserDao.insert(new user(username, password,email));
		return true;
	}

	public boolean checkExistEmail(String email) {
		return UserDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) {
		return UserDao.checkExistUsername(username);
	}


	@Override
	public void insert(user User) {
		UserDao.insert(User);
	}
}

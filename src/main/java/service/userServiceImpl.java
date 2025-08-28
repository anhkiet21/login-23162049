package service;
import model.user;

public class userServiceImpl implements userService {
	userDao UserDao = new userDaoImpl();
	public user login(String username,String password) {
		user User=this.get(username);
		if (User != null && password.equals(User.getPassword())) {
			 return User;
			 }
		return null;
	}
	public user get(String username) {
		return UserDao.get(username);
	}
}

package DAO;

import java.util.List;

import Model.User;

public interface UserDAO {
	void addUser(User user);
	User getuser(int userId);
	int updateUser(int id);
	int deleteUser(int userId);
	 List <User> getAllUsers();
	 //void updateUser(int id);
}

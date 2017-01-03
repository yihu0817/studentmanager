package com.ittx.stumanger.server;

import java.util.ArrayList;

import com.ittx.stumanger.model.User;

public interface UserServer {
	boolean checkUser(String userName,String passWord);
	boolean addUser(User user);
	ArrayList<User> getAllUser();
	void deleteUser(int id);
	User getUserById(int id);
	void updateUserByName(User user);
}

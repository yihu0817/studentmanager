package com.ittx.stumanger.dao;

import java.util.ArrayList;

import com.ittx.stumanger.model.User;

public interface UserDao {
	User checkUser(String userName,String passWord);//检查用户是否存在 
	void addUser(User user);//添加学生
	User getUser(String userName);
	ArrayList<User> getAllUser();
	void deleteUser(int id);
	User getUserById(int id);
	void updateUserByName(User user);
}

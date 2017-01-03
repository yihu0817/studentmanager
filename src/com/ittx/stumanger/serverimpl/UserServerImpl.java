package com.ittx.stumanger.serverimpl;

import java.util.ArrayList;

import com.ittx.stumanger.dao.UserDao;
import com.ittx.stumanger.daoimpl.UserDaoImpl;
import com.ittx.stumanger.model.User;
import com.ittx.stumanger.server.UserServer;

public class UserServerImpl implements UserServer {
	private UserDao userDao = new UserDaoImpl();
	@Override
	public boolean checkUser(String userName, String passWord) {
		User user = userDao.checkUser(userName, passWord);
		if(user == null){
			return false;
		}else{
			return true;
		}
	}
	@Override
	public boolean addUser(User user) {
		if(userDao.getUser(user.getUserName())==null){
			userDao.addUser(user);
			return true;
		}else{
			return false;
		}
	}
	@Override
	public ArrayList<User> getAllUser() {
		return userDao.getAllUser();
	}
	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
		
	}
	@Override
	public void updateUserByName(User user) {
		System.out.println("server :"+user);
		userDao.updateUserByName(user);
	}

}

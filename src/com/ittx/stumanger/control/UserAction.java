package com.ittx.stumanger.control;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.ittx.stumanger.model.User;
import com.ittx.stumanger.server.UserServer;
import com.ittx.stumanger.serverimpl.UserServerImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements RequestAware,ModelDriven<User>{
	private UserServer userServer = new UserServerImpl();
	private Map<String, Object> requestMap;
	private User user = new User();
	/**
	 * 添加用户
	 * @return
	 */
	public String add(){
		System.out.println("id :"+user.getId());
		if(user.getId() == 0){ //添加
			if(userServer.addUser(user)){
				return SUCCESS;
			}else{
				requestMap.put("error", "用户已存在!");
				return INPUT;
			}
		}else{
			userServer.updateUserByName(user);
			return SUCCESS;
		}
		
	}
	
	/**
	 * 显示用户列表
	 */
	public String show(){
		ArrayList<User> list = userServer.getAllUser();
		requestMap.put("userLists", list);
		return "list";
	}
	
	public String update(){
		int id = (int) requestMap.get("id");
		User user = userServer.getUserById(id);
		requestMap.put("user", user);
		return INPUT;
	}
	
	public String delete(){
		int id = (int) requestMap.get("id");
		userServer.deleteUser(id);
		return SUCCESS;
	}
	
	
	
	@Override
	public void setRequest(Map<String, Object> request) {
		requestMap = request;
	}

	@Override
	public User getModel() {
		return user;
	}
}

package com.ittx.stumanger.control;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.ittx.stumanger.model.User;
import com.ittx.stumanger.server.UserServer;
import com.ittx.stumanger.serverimpl.UserServerImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>,RequestAware {
	private User user = new User();
	private UserServer userServer = new UserServerImpl();
	private Map<String, Object> requestMap;
	@Override
	public User getModel() {
		return user;
	}

	@Override
	public String execute() throws Exception {
		if(userServer.checkUser(user.getUserName(), user.getPassWord())){
			return SUCCESS;
		}else{
			requestMap.put("error", "用户名或密码错误!");
			return INPUT;
		}
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		requestMap = request;
	}
	
	

}

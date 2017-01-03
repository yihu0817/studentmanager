package com.ittx.stumanger.control;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.ittx.stumanger.model.User;
import com.ittx.stumanger.server.UserServer;
import com.ittx.stumanger.serverimpl.UserServerImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>,RequestAware {
	private User user = new User();//接收表单提交数据
	private Map<String, Object> requestMap; //操作request对象
	private UserServer userServer = new UserServerImpl();  //业务实例
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

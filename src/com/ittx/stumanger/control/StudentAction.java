package com.ittx.stumanger.control;

import java.io.File;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.ittx.stumanger.model.Student;
import com.ittx.stumanger.server.StudentServer;
import com.ittx.stumanger.serverimpl.StudentServerImpl;
import com.ittx.stumanger.utils.FileUtil;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport implements RequestAware{
	private StudentServer studentServer = new StudentServerImpl();
	private Map<String, Object> requestMap;
	private File myfile; // File对象名
	private String myfileFileName; // 获取原文件名规则:File对象名+FileName，如:'myfile' +
									// 'FileName'
	private String name;  //姓名
	private int number;   //学号
	private int age;      //年龄
	private int sex;      //性别  1男  0女

	@Override
	public String execute() throws Exception {
		String saveDir = ServletActionContext.getServletContext().getRealPath("/upload");
		System.out.println("saveDir :"+saveDir);
		File saveFile = new File(saveDir, myfileFileName);
		FileUtil.createFile(saveFile);
		FileUtil.copeFile(myfile, saveFile);

		String headerUrl = "/upload/"+myfileFileName;
		Student student = new Student(name,age,number,sex==1?true:false,headerUrl);
		studentServer.addStudent(student);
		
		requestMap.put("message", "添加学生成功!");
		return SUCCESS;
	}

	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

	public String getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		requestMap = request;
		
	}


}

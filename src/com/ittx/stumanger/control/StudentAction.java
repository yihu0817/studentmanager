package com.ittx.stumanger.control;

import java.io.File;
import java.util.ArrayList;
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
	private String myfileFileName; // 获取原文件名规则:File对象名+FileName，如:'myfile' + 'FileName'
	private String name;  //姓名
	private int number;   //学号
	private int age;      //年龄
	private int sex;      //性别  1男  0女
	private int id;

	public String add() throws Exception {
		String headerUrl = ""; //保存头像地址
		if(id == 0){ //添加学生操作
			Student stu = studentServer.selectStudentByNumber(number);
			//判断学生是否已存在，null表示添加学生不存在
			if(stu == null){ 
				//是否上传头像     ！=null表示上传头像
				if(myfile != null){ 
					String saveDir = ServletActionContext.getServletContext().getRealPath("/upload");
					System.out.println("saveDir :"+saveDir);
					File saveFile = new File(saveDir, myfileFileName);
					FileUtil.createFile(saveFile);
					FileUtil.copeFile(myfile, saveFile);
					headerUrl = "/upload/"+myfileFileName;
				}
				Student student = new Student(name,age,number,sex==1?true:false,headerUrl);
				studentServer.addStudent(student);
				
				return SUCCESS;
			}else{
				requestMap.put("message","添加学生已在!");
				return INPUT;
			}
		}else{
			Student student = studentServer.selectStudentById(id);
			Student stu = studentServer.selectStudentByNumber(number);
			//判断修改学生是否已存在，null表示添加学生不存在
			if(stu == null || student.getNumber() == number){ 
				
				//是否修改头像     ！=null表示上传头像
				headerUrl = student.getHeaderImg();
				if(myfile != null){ 
					//删除原头像
					String oldDir = ServletActionContext.getServletContext().getRealPath("")+headerUrl;
					if(!headerUrl.equals(""))
						FileUtil.deleteFile(oldDir);
					
					//上传新头像
					String saveDir = ServletActionContext.getServletContext().getRealPath("/upload");
					File saveFile = new File(saveDir, myfileFileName);
					FileUtil.createFile(saveFile);
					FileUtil.copeFile(myfile, saveFile);
					headerUrl = "/upload/"+myfileFileName;
				}
				//更新数据
				student = new Student(id,name,age,number,sex==1?true:false,headerUrl);
				studentServer.updateStudent(student);
				
				return SUCCESS;
			}else{
				requestMap.put("message","学号已存在!");
				requestMap.put("student", student);
				return INPUT;
			}
		}
		
		
	}
	
	/**
	 * 获取修改学生信息
	 * @return
	 */
	public String update(){
		int number = (int) requestMap.get("number");
		Student student = studentServer.selectStudentByNumber(number);
		requestMap.put("student", student);
		return INPUT;
	}
	/**
	 * 显示所有学生列表
	 * @return
	 */
	public String show(){
		ArrayList<Student> list = studentServer.selectAllStudent();
		requestMap.put("studentLists", list);
		return "list";
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		requestMap = request;
		
	}


}

package com.ittx.stumanger.serverimpl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ittx.stumanger.dao.StudentDao;
import com.ittx.stumanger.daoimpl.StudentDaoImpl;
import com.ittx.stumanger.model.Student;
import com.ittx.stumanger.server.StudentServer;
import com.ittx.stumanger.utils.FileUtil;

/**
 * server 业务处理层
 * 
 * 
 * @author Administrator
 *
 */
public class StudentServerImpl implements StudentServer {
	private StudentDao studentDao = new StudentDaoImpl();

	@Override
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}
	
	@Override
	public boolean addStudent(HashMap<String, String> parameters, String rootDir) {
		String userName = parameters.get("name");
		int number = Integer.parseInt(parameters.get("number"));
		int age = Integer.parseInt(parameters.get("age"));
		String headerImg = parameters.get("headerImg");
		boolean sex = parameters.get("sex").equals("1") ? true : false;

		Student student = studentDao.selectStudentByNumber(number);
		// 判断学生是否存在
		if (student == null) {
			Student stu = new Student(userName, age, number, sex, headerImg);
			studentDao.addStudent(stu);
			return true;
		} else {
			// 如果学生存在删除上传的新头像
			if (!headerImg.equals("")) {
				try {
					FileUtil.deleteFile(rootDir + headerImg);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			return false;
		}
	}

	@Override
	public void deleteStudentByNumber(int number, String rootDir) {
		Student student = studentDao.selectStudentByNumber(number);
		String headerUrl = student.getHeaderImg();
		try {
			if (!headerUrl.equals("")) //headerUrl不为""执行删除头像操作
				FileUtil.deleteFile(rootDir + headerUrl);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		studentDao.deleteStudentByNumber(number);
	}

	@Override
	public ArrayList<Student> selectAllStudent() {
		ArrayList<Student> lists = studentDao.selectAllStudent();
		return lists;
	}

	@Override
	public Student selectStudentByNumber(int number) {
		Student student = studentDao.selectStudentByNumber(number);
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);

	}

}

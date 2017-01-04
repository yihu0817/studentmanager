package com.ittx.stumanger.server;

import java.util.ArrayList;
import java.util.HashMap;

import com.ittx.stumanger.model.Student;

public interface StudentServer {
	boolean addStudent(HashMap<String,String> parameters,String rootDir); // 添加学生业务

	void deleteStudentByNumber(int number,String rootDir); // 删除学生业务

	ArrayList<Student> selectAllStudent();// 查询所有学生业务

	Student selectStudentByNumber(int number); // 查询指定学号学生业务

	void updateStudent(Student student);// 修改学生业务
	
	void addStudent(Student student);
}

package com.ittx.stumanger.dao;

import java.util.ArrayList;

import com.ittx.stumanger.model.Student;

public interface StudentDao {
	void addStudent(Student student); // 添加学生

	void deleteStudentByNumber(int number); // 删除学生

	ArrayList<Student> selectAllStudent();// 查询所有学生

	Student selectStudentByNumber(int number); // 查询指定学号学生

	void updateStudent(Student student);// 修改学生
}

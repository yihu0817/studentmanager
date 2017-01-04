package com.ittx.stumanger.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ittx.stumanger.dao.StudentDao;
import com.ittx.stumanger.model.Student;
import com.ittx.stumanger.utils.ConnectDB;
/**
 * dao 数据处理层
 * 负责数据库操作
 * 
 */
public class StudentDaoImpl extends ConnectDB implements StudentDao {

	@Override
	public void addStudent(Student student) {
		String sql = "insert into student (name,number,age,sex,header_url)values(?,?,?,?,?)";
		Connection connect = null;
		PreparedStatement ps = null;

		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);

			ps.setString(1, student.getName());
			ps.setInt(2, student.getNumber());
			ps.setInt(3, student.getAge());
			ps.setBoolean(4, student.isSex());
			ps.setString(5, student.getHeaderImg());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			closeConnection(connect);
		}

	}

	@Override
	public void deleteStudentByNumber(int number) {
		String sql = "DELETE FROM student WHERE number = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, number);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(connect);
		}

	}

	@Override
	public ArrayList<Student> selectAllStudent() {
		String sql = "SELECT * FROM student";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Student> studentList = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();

			studentList = new ArrayList<>();
			while (rs.next()) {
				String name = rs.getString("name");
				int number = rs.getInt("number");
				int age = rs.getInt("age");
				boolean sex = rs.getBoolean("sex");
				String url = rs.getString("header_url");
				Student student = new Student(name, age,number, sex,url);
				studentList.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(connect);
		}

		return studentList;
	}

	@Override
	public Student selectStudentByNumber(int number) {
		String sql = "SELECT * FROM student WHERE number = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int num = rs.getInt("number");
				int age = rs.getInt("age");
				boolean sex = rs.getBoolean("sex");
				String url = rs.getString("header_url");
				student = new Student(id,name, age,num,  sex,url);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(connect);
		}

		return student;
	}
	
	@Override
	public Student selectStudentById(int ids) {
		String sql = "SELECT * FROM student WHERE id = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, ids);
			rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int num = rs.getInt("number");
				int age = rs.getInt("age");
				boolean sex = rs.getBoolean("sex");
				String url = rs.getString("header_url");
				student = new Student(id,name, age,num,  sex,url);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(connect);
		}

		return student;
	}
	
	public void updateStudent(Student student){
		String sql = "UPDATE student SET name=?,age=?,sex=?,header_url=?,number=? where id=?";
		Connection connect = null;
		PreparedStatement ps = null;

		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);

			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setBoolean(3, student.isSex());
			ps.setString(4, student.getHeaderImg());
			ps.setInt(5, student.getNumber());
			ps.setInt(6,student.getId());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			closeConnection(connect);
		}
	}
	
	

}

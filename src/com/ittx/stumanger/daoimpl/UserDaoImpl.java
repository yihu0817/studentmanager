package com.ittx.stumanger.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ittx.stumanger.dao.UserDao;
import com.ittx.stumanger.model.User;
import com.ittx.stumanger.utils.ConnectDB;

public class UserDaoImpl extends ConnectDB implements UserDao {

	@Override
	public User checkUser(String userName, String passWord) {
		String sql = "select * from user where name = ? and password=?";
		Connection connect = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String psw = rs.getString("password");
				user = new User(name, psw);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if(ps != null){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(connect);
		}
		return user;
	}

	@Override
	public void addUser(User user) {
		String sql = "insert into user (name,password)values(?,?)";
		Connection connect = getConnection();
		PreparedStatement ps = null;
		try {
			ps =connect.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null){
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
	public User getUser(String userName) {
		String sql = "select * from user where name = ?";
		Connection connect = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String psw = rs.getString("password");
				user = new User(name, psw);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if(ps != null){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(connect);
		}
		return user;
	}

	@Override
	public ArrayList<User> getAllUser() {
		String sql = "SELECT * FROM user";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<User> userLists = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();

			userLists = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("uid");
				String name = rs.getString("name");
				String password = rs.getString("password");
				User user = new User(id,name,password);
				userLists.add(user);
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

		return userLists;
	}



	@Override
	public void  deleteUser(int id) {
		String sql = "delete from user where uid = ?";
		Connection connect = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if(ps != null){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(connect);
		}
	}

	@Override
	public User getUserById(int id) {
		String sql = "select * from user where uid = ?";
		Connection connect = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				int uId = rs.getInt("uid");
				String name = rs.getString("name");
				String psw = rs.getString("password");
				user = new User(uId,name, psw);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if(ps != null){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(connect);
		}
		return user;
	}

	@Override
	public void updateUserByName(User user) {
		System.out.println("dao :"+user);
		String sql = "update user set password=? where name=?";
		Connection connect = getConnection();
		PreparedStatement ps = null;
		try {
			ps =connect.prepareStatement(sql);
			ps.setString(1, user.getPassWord());
			ps.setString(2, user.getUserName());
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			closeConnection(connect);
		}
		
	}
	
	public static void main(String args[]){
		new UserDaoImpl().updateUserByName(new User("小明","abcd"));
	}
}

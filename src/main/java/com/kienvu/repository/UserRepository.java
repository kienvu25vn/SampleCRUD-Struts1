package com.kienvu.repository;

import java.nio.channels.NonReadableChannelException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sound.sampled.LineListener;

import com.kienvu.dao.DBContext;
import com.kienvu.model.User;
import com.kienvu.service.UserService;
import com.sun.java_cup.internal.internal_error;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

public class UserRepository {
	
	private Connection connection;
	
	public UserRepository() {
		try {
			this.connection = new DBContext().getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<User> getUsers(){
		List<User> list = new ArrayList<User>();
		String query = "SELECT * FROM account";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	public int insertUser(User user){
		int i = 0;
		String query = "INSERT INTO account (username , password , fullname , age , email) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullname());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getEmail());
			i = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return i;
	}
	public int removeUser(int idUser) {
		String query = "DELETE FROM account where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, idUser);
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public User checkLogin(User user) {
		String query = "SELECT * FROM account WHERE username = ? and password = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rSet = ps.executeQuery();
			if(rSet.next()) {
				return new User(rSet.getString("fullname") , rSet.getInt("age") , rSet.getString("email"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		User user = new User();
		user.setUsername("kienvu");
		user.setPassword("123");
		System.out.print(new UserRepository().checkLogin(user).getFullname());
	}
}

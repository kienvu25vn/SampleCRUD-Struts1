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
				user.setId(rs.getInt(1));
				user.setName(rs.getString("name"));
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
		String query = "INSERT INTO account (name , age , email) VALUES (?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.setString(3, user.getEmail());
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
}

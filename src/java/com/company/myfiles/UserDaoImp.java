package com.company.myfiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.myfiles.User;

public class UserDaoImp implements UserDao {
	 @Override
	    public boolean addUser(User user) {
	        

	        try  {
                    Connection connection = DBUtil.getConnection();
                    String query = "INSERT INTO user1 (email, username, password) VALUES (?, ?, ?)";
	             PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, user.getEmail());
	            preparedStatement.setString(2, user.getUsername());
	            
	            preparedStatement.setString(3, user.getPassword());

	            int rowsAffected = preparedStatement.executeUpdate();

	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;	        }

	    }

	    @Override
	    public boolean isValidUser(String email, String password) {
	        String query = "SELECT * FROM user1 WHERE email = ? AND password = ?";
	    	 try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            return resultSet.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	}
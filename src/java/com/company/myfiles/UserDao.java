package com.company.myfiles;

import com.company.myfiles.User;

public interface UserDao {

	boolean addUser(User user);
	boolean isValidUser(String username, String password);
}
package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	void addUser(User user)throws Exception;
	boolean isLogin(String username,String password)throws Exception;
	List<User> findAllUser()throws Exception;
	boolean isExitName(String username)throws Exception;
	void deleteUser(User user)throws Exception;
	void updateUser(User user)throws Exception;
	User getUser(String username)throws Exception;
}

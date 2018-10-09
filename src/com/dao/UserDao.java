package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {
	void save(User user)throws Exception;
	List<User> findAllUser()throws Exception;
	User getByName(String name)throws Exception;
	User getByNameAndPwd(String username,String password)throws Exception;
	void deleteUser(User user)throws Exception;
	void updateUser(User user)throws Exception;
}

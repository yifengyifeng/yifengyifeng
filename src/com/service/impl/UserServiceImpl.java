package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.model.User;
import com.service.UserService;

@SuppressWarnings("deprecation")
public class UserServiceImpl implements UserService {
	private  UserDao userDao;
	
	public UserServiceImpl(){
		Resource cr = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(cr);
		userDao=(UserDaoImpl) factory.getBean("userDao");
	}
	@Override
	public void addUser(User user) throws Exception {
		// TODO 自动生成的方法存根
		userDao.save(user);

	}

	@Override
	public boolean isLogin(String username, String password) throws Exception {
		User user=userDao.getByNameAndPwd(username, password);
		if(user!=null){
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public List<User> findAllUser() throws Exception {
		// TODO 自动生成的方法存根
		return userDao.findAllUser();
	}

	@Override
	public boolean isExitName(String username) throws Exception {
		User user=userDao.getByName(username);
		//System.out.println("UserService:"+username);
		if(user!=null){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public void deleteUser(User user) throws Exception {
		// TODO 自动生成的方法存根
		userDao.deleteUser(user);
		
	}
	@Override
	public void updateUser(User user) throws Exception {
		// TODO 自动生成的方法存根
		userDao.updateUser(user);
	}
	@Override
	public User getUser(String username) throws Exception {
		User user=userDao.getByName(username);
		return user;
	}


}

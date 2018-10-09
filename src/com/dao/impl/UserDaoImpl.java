package com.dao.impl;

import java.util.List;



import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.dao.UserDao;
import com.model.User;



public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public void save(User user) throws Exception {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(user);
	}

	@Override
	public List<User> findAllUser() throws Exception {
		// TODO 自动生成的方法存根
		String hql="From User where limit <> 0";
		@SuppressWarnings("unchecked")
		List<User> userList=this.getHibernateTemplate().find(hql);
		return userList;
	}

	@Override
	public User getByName(String name) throws Exception {
		// TODO 自动生成的方法存根
		String hql="From User where username=?";
		User user =null;
		Session session=null;
		try{
			session=this.getSession();
			user=(User)session.createQuery(hql).setParameter(0, name).uniqueResult();
		}
		finally{
			this.releaseSession(session);
		}
		return user;
	}

	@Override
	public User getByNameAndPwd(String username, String password) throws Exception {
		// TODO 自动生成的方法存根
		String hql="From User WHERE username=? and password=?";
		User user =null;
		Session session=null;
		try{
			session=this.getSession();
			user=(User)session.createQuery(hql).setParameter(0, username).setParameter(1, password).uniqueResult();
		}
		finally{
			this.releaseSession(session);
		}
		return user;
	}

	@Override
	public void deleteUser(User user) throws Exception {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().delete(user);
		
	}

	@Override
	public void updateUser(User user) throws Exception {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().update(user);
	}
	

}

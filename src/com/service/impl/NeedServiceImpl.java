package com.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.dao.NeedDao;
import com.dao.impl.*;
import com.model.Need;
import com.service.NeedService;

@SuppressWarnings("deprecation")
public class NeedServiceImpl implements NeedService {
	private NeedDao needDao;
	
	public NeedServiceImpl(){
		Resource cr = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(cr);
		needDao=(NeedDaoImpl) factory.getBean("needDao");
	}
	@Override
	public void addNeed(Need need) throws Exception {
		// TODO 自动生成的方法存根
		needDao.addNeed(need);
	}

	@Override
	public void updateNeedState(String num, String state) throws Exception {
		// TODO 自动生成的方法存根
		Need need=needDao.findNeedByNum(num);
		need.setState(state);
		needDao.updateNeed(need);
	}

	@Override
	public void deleteNeed(String num) throws Exception {
		needDao.deleteNeed(num);
		
	}

	@Override
	public List<Need> findAllNeed() throws Exception {
		// TODO 自动生成的方法存根
		return needDao.findAllNeed();
	}

	@Override
	public List<Need> findNeedByUser(String username) throws Exception {
		// TODO 自动生成的方法存根
		return needDao.findNeedByUser(username);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Need> query(int st, String fromDate, String toDate) throws Exception {
		// TODO 自动生成的方法存根
		return needDao.query(st, fromDate, toDate);
	}

	@Override
	public List<Need> query(String name, int st, String fromDate, String toDate) throws Exception {
		// TODO 自动生成的方法存根
		return needDao.query(name,st, fromDate, toDate);
	}

	@Override
	public List<Need> query(int st, String fromDate, String toDate, String jgsx, String hzms) throws Exception {
		// TODO 自动生成的方法存根
		
		
		return needDao.query(st, fromDate, toDate,jgsx,hzms);
	}

	@Override
	public List<Need> query(int choose, String fl) throws Exception {
		// TODO 自动生成的方法存根
		
		return needDao.query(choose, fl);
	}

	@Override
	public List<Need> query(String sqlCondition) throws Exception {
		String sql="select * from t_need where"+sqlCondition;
		return needDao.queryBySql(sql);
	}
	
	
	
	@Override
	public int getNeedNumByState(String state) throws Exception {
		String hql="from Need where state =";
		hql+="'"+state+"'";
		return needDao.getNumByHql(hql);
	}
	@Override
	public Need findNeedByNum(String num) throws Exception {
		// TODO 自动生成的方法存根
		return needDao.findNeedByNum(num);
	}
	@Override
	public List<Need> queryByState(String state) throws Exception {
		// TODO 自动生成的方法存根
		
		return needDao.queryByState(state);
	}

}

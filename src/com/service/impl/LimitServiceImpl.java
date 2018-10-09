package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.dao.LimitDao;
import com.dao.impl.LimitDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.model.Limit;
import com.service.LimitService;

@SuppressWarnings({ "unused", "deprecation" })
public class LimitServiceImpl implements LimitService {
	private LimitDao limitDao;
	public LimitServiceImpl(){
		Resource cr = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(cr);
		limitDao=(LimitDaoImpl) factory.getBean("limitDao");
	}
	@Override
	public void addLimit(Limit limit) throws Exception {
		// TODO 自动生成的方法存根
		limitDao.addLimit(limit);
	}

	@Override
	public void updateLimit(Limit limit) throws Exception {
		// TODO 自动生成的方法存根
		limitDao.updateLimit(limit);
	}

	@Override
	public Limit findLimitById(int id) throws Exception {
		// TODO 自动生成的方法存根
		return limitDao.findLimitById(id);
	}

	@Override
	public List<Limit> findAllLimit() throws Exception {
		// TODO 自动生成的方法存根
		return limitDao.findAllLimit();
	}

}

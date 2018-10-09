package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.LimitDao;
import com.model.Limit;

public class LimitDaoImpl extends HibernateDaoSupport implements LimitDao {

	@Override
	public void addLimit(Limit limit) throws Exception {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(limit);
	}

	@Override
	public Limit findLimitById(int id) throws Exception {
		// TODO 自动生成的方法存根
		String hql="From Limit where id=?";
		Limit limit =null;
		Session session=null;
		try{
			session=this.getSession();
			limit=(Limit)session.createQuery(hql).setParameter(0, id).uniqueResult();
		}
		finally{
			this.releaseSession(session);
		}
		return limit;
	}

	@Override
	public List<Limit> findAllLimit() throws Exception {
		// TODO 自动生成的方法存根
		String hql="From Limit";
		@SuppressWarnings("unchecked")
		List<Limit> limitList=this.getHibernateTemplate().find(hql);
		return limitList;
	}

	@Override
	public void updateLimit(Limit limit) throws Exception {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().update(limit);
	}

}

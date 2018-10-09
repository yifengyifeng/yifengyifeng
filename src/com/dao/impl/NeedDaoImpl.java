package com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.NeedDao;
import com.model.Need;

public class NeedDaoImpl extends HibernateDaoSupport implements NeedDao {

	@Override
	public void addNeed(Need need) throws Exception {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(need);
	}

	@Override
	public List<Need> findAllNeed() throws Exception {
		// TODO 自动生成的方法存根
		String hql="from Need";
		@SuppressWarnings("unchecked")
		List<Need> needList=this.getHibernateTemplate().find(hql);
		return needList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Need> findNeedByUser(String username) throws Exception {
		// TODO 自动生成的方法存根
		String hql="from Need where tjyh=?";
		List<Need> needList =null;
		Session session=null;
		try{
			session=this.getSession();
			needList=(List<Need>)session.createQuery(hql).setParameter(0, username).list();
		}
		finally{
			this.releaseSession(session);
		}
		return needList;
	}

	@Override
	public void updateNeed(Need need) throws Exception {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().update(need);
	}

	@Override
	public void deleteNeed(String num) throws Exception {
		// TODO 自动生成的方法存根
		Need need=new Need();
		need.setNum(num);
		this.getHibernateTemplate().delete(need);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Need> queryBySql(String sql) throws Exception {
		// TODO 自动生成的方法存根
		List<Need> needList =null;
		Session session=null;
		try{
			session=this.getSession();
			needList=(List<Need>)session.createSQLQuery(sql).addEntity(Need.class).list();  
		}
		finally{
			this.releaseSession(session);
		}
		return needList;
	}

	@Override
	public List<Need> findNeedByCriteria(List<Criterion> criterions) throws Exception {
		// TODO 自动生成的方法存根
		
		List<Need> needList =null;
		Session session=null;
		try{
			session=this.getSession();
			Criteria criteria=session.createCriteria(Need.class);
			if(criterions!=null){
				for(int i=0;i<criterions.size();i++){
					criteria.add(criterions.get(i));
				}
			}
			
			criteria.addOrder(Order.desc("tjsj"));
			needList=(List<Need>)criteria.list(); 
		}
		finally{
			this.releaseSession(session);
		}
		return needList;
	}

	@Override
	public Need findNeedByNum(String num) throws Exception {
		String hql="From Need where num=?";
		Need need =null;
		Session session=null;
		try{
			session=this.getSession();
			need=(Need)session.createQuery(hql).setParameter(0, num).uniqueResult();
		}
		finally{
			this.releaseSession(session);
		}
		return need;
	}

	@Override
	public int getNumByHql(String hql) throws Exception {
		// TODO 自动生成的方法存根
		Session session=null;
		int sum=0;
		try{
			session=this.getSession();
			sum=(Integer)session.createQuery(hql).list().size();
		}
		finally{
			this.releaseSession(session);
		}
		return sum;
	}

	@Override
	public List<Need> query(int st, String fromDate, String toDate) throws Exception {
		// TODO 自动生成的方法存根
		List<Need> needList =null;
		Session session=null;
		try{
			session=this.getSession();
			Criteria criteria=session.createCriteria(Need.class);
			criteria.add(Restrictions.between("tjsj", fromDate, toDate));
			if(st!=0){
				String s[]={"未审核","已通过","被退回"};
				criteria.add(Restrictions.eq("state", s[st-1]));
			}
			criteria.addOrder(Order.desc("tjsj"));
			needList=(List<Need>)criteria.list(); 
		}
		finally{
			this.releaseSession(session);
		}
		return needList;
	}

	@Override
	public List<Need> query(String name, int st, String fromDate, String toDate) throws Exception {
		// TODO 自动生成的方法存根
		List<Need> needList =null;
		Session session=null;
		try{
			session=this.getSession();
			Criteria criteria=session.createCriteria(Need.class);
			criteria.add(Restrictions.eq("tjyh", name));
			criteria.add(Restrictions.between("tjsj", fromDate, toDate));
			if(st!=0){
				String s[]={"未审核","已通过","被退回"};
				criteria.add(Restrictions.eq("state", s[st-1]));
			}
			criteria.addOrder(Order.desc("tjsj"));
			needList=(List<Need>)criteria.list(); 
		}
		finally{
			this.releaseSession(session);
		}
		return needList;
	}

	@Override
	public List<Need> query(int st, String fromDate, String toDate, String jgsx, String hzms) throws Exception {
		// TODO 自动生成的方法存根
		List<Need> needList =null;
		Session session=null;
		try{
			session=this.getSession();
			Criteria criteria=session.createCriteria(Need.class);
			criteria.add(Restrictions.eq("jgsx", jgsx));
			criteria.add(Restrictions.eq("hzms", hzms));
			criteria.add(Restrictions.between("tjsj", fromDate, toDate));
			if(st!=0){
				String s[]={"未审核","已通过","被退回"};
				criteria.add(Restrictions.eq("state", s[st-1]));
			}
			criteria.addOrder(Order.desc("tjsj"));
			needList=(List<Need>)criteria.list(); 
		}
		finally{
			this.releaseSession(session);
		}
		return needList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Need> query(int choose, String fl) throws Exception {
		// TODO 自动生成的方法存根
		List<Need> needList =null;
		Session session=null;
		try{
			session=this.getSession();
			Criteria criteria=session.createCriteria(Need.class);
			if(choose==1){
				criteria.add(Restrictions.like("xkfl", fl+"%"));
			}
			else{
				criteria.add(Restrictions.like("yyhy", fl+"%"));
			}
			criteria.addOrder(Order.desc("tjsj"));
			needList=(List<Need>)criteria.list(); 
		}
		finally{
			this.releaseSession(session);
		}
		return needList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Need> queryByState(String state) throws Exception {
		// TODO 自动生成的方法存根
		List<Need> needList =null;
		Session session=null;
		try{
			session=this.getSession();
			Criteria criteria=session.createCriteria(Need.class);
			criteria.add(Restrictions.eq("state", state));
			criteria.addOrder(Order.desc("tjsj"));
			needList=(List<Need>)criteria.list(); 
		}
		finally{
			this.releaseSession(session);
		}
		return needList;
	}


}

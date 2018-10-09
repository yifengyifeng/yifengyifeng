package com.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import com.model.Need;
public interface NeedDao {
	void addNeed(Need need)throws Exception;
	List<Need> findAllNeed()throws Exception;
	List<Need> findNeedByUser(String username)throws Exception;
	void updateNeed(Need need)throws Exception;
	void deleteNeed(String num)throws Exception;
	List<Need> queryBySql(String sql)throws Exception;
	List<Need> findNeedByCriteria(List<Criterion> criterions)throws Exception;
	Need findNeedByNum(String num)throws Exception;
	int getNumByHql(String hql)throws Exception;
	List<Need> query(int st,String fromDate,String toDate)throws Exception;
	List<Need> query(String name,int st,String fromDate,String toDate)throws Exception;
	List<Need> query(int st,String fromDate,String toDate,String jgsx,String hzms)throws Exception;
	List<Need> query(int choose,String fl)throws Exception;
	List<Need> queryByState(String state)throws Exception;
}

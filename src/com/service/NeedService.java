package com.service;

import java.util.List;

import com.model.Need;

public interface NeedService {
	void addNeed(Need need)throws Exception;
	void updateNeedState(String num,String state)throws Exception;
	void deleteNeed(String num)throws Exception;
	Need findNeedByNum(String num)throws Exception;
	List<Need> findAllNeed()throws Exception;
	List<Need> findNeedByUser(String username)throws Exception;
	List<Need> query(int st,String fromDate,String toDate)throws Exception;
	List<Need> query(String name,int st,String fromDate,String toDate)throws Exception;
	List<Need> query(int st,String fromDate,String toDate,String jgsx,String hzms)throws Exception;
	List<Need> query(int choose,String fl)throws Exception;
	List<Need> query(String condition)throws Exception;
	List<Need> queryByState(String state)throws Exception;
	int getNeedNumByState(String state)throws Exception;
}

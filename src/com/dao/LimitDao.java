package com.dao;
import java.util.List;

import com.model.Limit;
public interface LimitDao {
	void addLimit(Limit limit)throws Exception;
	Limit findLimitById(int id)throws Exception;
	List<Limit> findAllLimit()throws Exception;
	void updateLimit(Limit limit)throws Exception;
}

package com.util;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JsonUtil {
	public JsonUtil(){}
	public static String ClassToJson(Object test){ 

		//两种方式均可
		return JSONSerializer.toJSON(test).toString(); 
		//return JSONObject.fromObject(test).toString();
	}
	
	public static String ArrayToJson(List list){
		
		return JSONArray.fromObject(list).toString();
	}
	
	public static String MapToJson(Map map){
		return JSONObject.fromObject(map).toString();
	}
}

package com.huice.Interface;


import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {

	public static String toJson(Object src){
		return new Gson().toJson(src);
	}
	
	public static Map<String, Object> fromJson(String jsonString){
		return new Gson().fromJson(jsonString, new TypeToken<Map<String, Object>>() {}.getType());
	}
}

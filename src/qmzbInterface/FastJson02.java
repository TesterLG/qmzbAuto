package com.huice.Interface;


import java.util.Map;

import com.alibaba.fastjson.JSON;

public class FastJson02 {

	public static void main(String[] args){
		
		String jsonString = Gson01.getJsonString();
		@SuppressWarnings("unchecked")
		Map<String,String> colors = JSON.parseObject(jsonString, Map.class);
		for (String key : colors.keySet()) {
			System.out.println(key+":"+colors.get(key));
		}
	}
}

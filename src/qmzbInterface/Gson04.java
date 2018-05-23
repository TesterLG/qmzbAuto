package com.huice.Interface;


import java.util.Map;
import com.google.gson.Gson;


public class Gson04 {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		String jasonString = Gson01.getJsonString();
		@SuppressWarnings("unchecked")
		Map<String, String> colors = gson.fromJson(jasonString,Map.class);
		for (String key : colors.keySet()) {
			System.out.println("key:"+key+" value:"+colors.get(key));
		}
			
	}
}

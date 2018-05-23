package com.huice.Interface;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class Gson01 {

	public static void main(String[] args) {
		
		 int[] numbers = {7, 1, 2, 3, 4, 5, 6};
	     String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	     Map<Integer, String> map = new HashMap<Integer, String>();
	     
	     for(int i=0;i<numbers.length;i++){
	    	 map.put(numbers[i], days[i]);
	     }
	     
	     Gson gson = new Gson();
//	     String numbersJson = gson.toJson(numbers);
//	     String daysJson = gson.toJson(days);
	     String jsondata = gson.toJson(map);
//	     System.out.println("numbersJson = " + numbersJson);
//	     System.out.println("daysJson = " + daysJson);
	     System.out.println("jsondata = " + jsondata);
	}
	
	public static String getJsonString(){
        Map<String, String> colours = new HashMap<String, String>();
        colours.put("BLACK", "#000000");
        colours.put("RED", "#FF0000");
        colours.put("GREEN", "#008000");
        colours.put("BLUE", "#0000FF");
        colours.put("YELLOW", "#FFFF00");
        colours.put("WHITE", "#FFFFFF");
        Gson gson = new Gson();
        String json = gson.toJson(colours);
		return json;		
	}
}

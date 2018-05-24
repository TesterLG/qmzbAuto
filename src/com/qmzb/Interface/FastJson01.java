package com.qmzb.Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;



public class FastJson01 {

	public static void main(String[] args){		
		parseObject();
	}
	
	public static void parseObject(){
		 int[] numbers = {7, 1, 2, 3, 4, 5, 6};
	     String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	     Map<Integer, String> map = new HashMap<Integer, String>();
	     
	     for(int i=0;i<numbers.length;i++){
	    	 map.put(numbers[i], days[i]);
	     }

	     String numbersJson = JSON.toJSONString(numbers);
	     String daysJson = JSON.toJSONString(days);
	     String jsondata = JSON.toJSONString(map);
	     System.out.println("numbersJson = " + numbersJson);
	     System.out.println("daysJson = " + daysJson);
	     System.out.println("jsondata = " + jsondata);
	}
	
	public static void parseJavaBean(){
		List<Student> students = new ArrayList<Student>();
		Map<String, List<Student>> map = new HashMap<String, List<Student>>();
		
		for(int i=0;i<10;i++){
			Student s = new Student();
			s.setName("Student"+i);
			s.setNativePlace(Student.createNativePlace());
			s.setDateOfBirth(Student.createDateOfBirth("1970-01-01", "1998-12-31"));		
			students.add(s);
		}
		map.put("studentArray", students);
		String studentsJson = JSON.toJSONString(map);
		System.out.println(studentsJson);
	}
}

package com.qmzb.Interface;


import com.google.gson.Gson;

public class Gson02 {

	public static void main(String[] args) {
		Student student = new Student("田田", "北京", "1990-01-01");
		Gson gson = new Gson();
		String studentJson = gson.toJson(student);
		System.out.println(studentJson);
	}
}

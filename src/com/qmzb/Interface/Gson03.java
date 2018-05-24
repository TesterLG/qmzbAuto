package com.qmzb.Interface;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Gson03 {
		
	public static void main(String[] args) {
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
		String studentsJson = new Gson().toJson(map);
		System.out.println(studentsJson);		
	}
			
}

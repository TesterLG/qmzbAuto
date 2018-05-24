package com.qmzb.Interface;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

public class JsonPath01 {

	public static void main(String[] args) throws IOException{

		List<Object> resultsList = JsonPath.read(new File("book.json"), "$..book[?(@.price>35)].title");
		for (Object jo : resultsList) {
			System.out.println(jo.toString());
		}

		Object object = JsonPath.read(new File("book.json"),"$..book[(@.length-1)].year");
		System.out.println(object.toString());

	}
	
}

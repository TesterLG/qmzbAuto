package com.huice.Interface;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class JsonPath02 {

	public static void main(String[] args) throws IOException{
		JsonPath path = JsonPath.compile("$.bookstore.book[*]"); 
	    List<Object> books = path.read(new File("book.json"));
//	    String result = path.read("aaaaaa");
	    System.out.println(path.getPath());

	}

}

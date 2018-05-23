package com.huice.Interface;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

public class JsonPath03 {

	public static void main(String[] args) throws IOException{
		JsonPath rootPath = JsonPath.compile("$.bookstore.book[?]"); 
		Filter filter = Filter.filter(Criteria.where("price").gte(30).and("category").in("COOKING"));
		List<Object> resultsList = JsonPath.read(new File("book.json"), rootPath.getPath(),filter);
		for (Object object : resultsList) {
			System.out.println(object.toString());
		}

	}
}

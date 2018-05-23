package com.huice.Interface;

import java.util.ArrayList;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class JsonPathOprator {

	private String jsonString;
	
	public JsonPathOprator(String jsonString){
		this.jsonString = jsonString;
	}
	
	public String getJsonValue(String jsonPathExpression){
		return JsonPath.read(this.jsonString, jsonPathExpression).toString();
	}
	
	public List<String> getJsonValues(String jsonPathExpression){
		List<Object> objs=JsonPath.read(this.jsonString, jsonPathExpression);
		List<String> valuesList = new ArrayList<String>();
		for (Object value : objs) {
			valuesList.add(value.toString());
		}
		return valuesList;
	}
	
	public int getJsonCount(String jsonPathExpression){
		int count=0;
		List<Object> objs=JsonPath.read(this.jsonString, jsonPathExpression);
		if(objs!=null){
			count=objs.size();
		}
		return count;
	}
}

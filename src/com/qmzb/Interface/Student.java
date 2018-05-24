package com.qmzb.Interface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class Student {
    private String name;
    private String nativePlace;
    private String dateOfBirth;

    public Student() {
    }

    public Student(String name, String nativePlace, String dateOfBirth) {
        this.name = name;
        this.nativePlace = nativePlace;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public static String createNativePlace() {
		String np = null;
		switch (new Random().nextInt(3)) {
		case 0:
			np = "北京";
			break;
		case 1:
			np = "上海";
			break;			
		case 2:
			np = "广州";
			break;			
		default:
			break;
		}
		
		return np;	
	}
		
    public static String createDateOfBirth(String beginDate, String endDate) {  
	        try {  
	            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	            Date start = format.parse(beginDate);
	            Date end = format.parse(endDate);

	            if (start.getTime() >= end.getTime()) {  
	                return null;  
	            }  
	            long date = random(start.getTime(), end.getTime());  
	  
	            return format.format(new Date(date));  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return null;  
	    }  
	  
	    private static long random(long begin, long end) {  
	        long rtn = begin + (long) (Math.random() * (end - begin));  
	        if (rtn == begin || rtn == end) {  
	            return random(begin, end);  
	        }  
	        return rtn;  
	    }  
	    
}

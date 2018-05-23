package com.huice.Interface;


import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Base64Tool {

	public static void main(String[] args){  
        String str = "Man";  
        try{  
            byte[] encodeBase64 = Base64.encodeBase64(str.getBytes("UTF-8"));  
            System.out.println("RESULT: " + new String(encodeBase64));  
        } catch(UnsupportedEncodingException e){  
            e.printStackTrace();  
        }  
    }  
	
	public static String encode(String str){
		String result = null;
		try {
			byte[] encodeBase64 = Base64.encodeBase64(str.getBytes("UTF-8"));
			result = new String(encodeBase64);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		return result;	
	}
	
	public static String encode(String str, String charset){
		String result = null;
		try {
			byte[] encodeBase64 = Base64.encodeBase64(str.getBytes(charset));
			result = new String(encodeBase64);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		return result;		
	}
	
	public static String decode(String str){
		String result = null;
		try {
			byte[] decodeBase64 = Base64.decodeBase64(str.getBytes("UTF-8"));
			result = new String(decodeBase64);	
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		return result;	
	}
	
	public static String decode(String str, String charset){
		String result = null;
		try {
			byte[] decodeBase64 = Base64.decodeBase64(str.getBytes(charset));
			result = new String(decodeBase64);	
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		return result;	
	}
}

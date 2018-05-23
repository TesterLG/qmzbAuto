package com.huice.Interface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class HttpClient01 {
//BasicNameValuePair
	private static String STATUS = "status";
	private static String RESPONSE = "response";
	private static String TIME = "time";
	private static String USER = "C100000362";
	private static String PWD = "4a071cd838d7fbeec1225dd7d125be3a";

	public static void main(String[] args) {
//		CloseableHttpClient httpClient = HttpClients.createDefault();	
//		try {
//			URI uri = new URIBuilder()
//							.setScheme("http")
//							.setHost("api.lixing.biz/service")
//							.setParameter("method", "getLocationInfo")
//							.setParameter("user", "C100000362")
//							.setParameter("sign", Md5Tool.getInstance().getLongToken("4a071cd838d7fbeec1225dd7d125be3a", "UTF-8"))
//							.build();
//			HttpGet  httpGet = new HttpGet(uri);
//			CloseableHttpResponse response = httpClient.execute(httpGet);
//			if(response.getStatusLine().getStatusCode()==200){
//				System.out.println("请求成功");
//				System.out.println(stream2String(response.getEntity().getContent()));
//				
//			}else{
//				System.out.println("请求失败");
//			}
//			
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("method", "getLocationInfo");
		map.put("user", USER);
		map.put("sign", Md5Tool.getInstance().getLongToken(PWD, "UTF-8"));
		 Map<String, String> response = doGet("api.lixing.biz/service", null, map);
		 if(response.get(STATUS).equals("200")){
			 System.out.println(response.get(TIME));
//			 System.out.println(response.get(RESPONSE));
			 XmlStringParser xml = new XmlStringParser(response.get(RESPONSE));
			 xml.Load();
			 System.out.println(xml.getElements("//location").size());
		 }
	}
	

	public static Map<String,String> doPost(String url, Map<String, String> headers, Map<String, String> parameters){
		Map<String,String> result = new HashMap<String,String>();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> list = new ArrayList<NameValuePair>(parameters.size());
		
		if(headers!=null && headers.size()!=0){
			for (String key : headers.keySet()) {
				httpPost.setHeader(key, headers.get(key));
			}
		}
		
		if(parameters!=null && parameters.size()!=0){
			for (String key : parameters.keySet()) {
				list.add(new BasicNameValuePair(key,parameters.get(key)));
			}
		}
		
		try {
			Date start_date=new Date(); 
			httpPost.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
			CloseableHttpResponse response = httpClient.execute(httpPost);
			int code = response.getStatusLine().getStatusCode();
			if(code==200){
				result.put(STATUS, String.valueOf(code));
				result.put(TIME, String.valueOf(new Date().getTime()-start_date.getTime()));
				result.put(RESPONSE, stream2String(response.getEntity().getContent()));
			}else{
				result.put(STATUS, String.valueOf(code));
				result.put(TIME, String.valueOf(new Date().getTime()-start_date.getTime()));
				result.put(RESPONSE, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put(STATUS, null);
			result.put(RESPONSE, null);
			result.put(TIME, null);
		}finally{
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static Map<String,String> doGet(String hostName, Map<String, String> headers, Map<String, String> parameters){
		Map<String,String> result = new HashMap<String,String>();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		URIBuilder uri = new URIBuilder();
		uri.setScheme("http");
		uri.setHost(hostName);
		if(parameters!=null && parameters.size()!=0){
			for (String key : parameters.keySet()) {
				uri.setParameter(key, parameters.get(key));
			}
		}
				
		try {
			HttpGet  httpGet = new HttpGet(uri.build());
			
			if(headers!=null && headers.size()!=0){
				for (String key : headers.keySet()) {
					httpGet.setHeader(key, headers.get(key));
				}
			}
			Date start_date=new Date(); 
			CloseableHttpResponse response = httpClient.execute(httpGet);
			int code = response.getStatusLine().getStatusCode();
			if(code==200){
				result.put(STATUS, String.valueOf(code));
				result.put(TIME, String.valueOf(new Date().getTime()-start_date.getTime()));
				result.put(RESPONSE, stream2String(response.getEntity().getContent()));
			}else{
				result.put(STATUS, String.valueOf(code));
				result.put(TIME, String.valueOf(new Date().getTime()-start_date.getTime()));
				result.put(RESPONSE, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put(STATUS, null);
			result.put(RESPONSE, null);
			result.put(TIME, null);
		}finally{
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static String stream2String(InputStream in){
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			while ((line = br.readLine())!=null) {
				sb.append(line);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
	
}

package com.qmzb.Interface;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.qmzb.base.XmlParser;


public class XmlStringParser extends XmlParser{

	private String XmlString;
	private Map<String,String> nameSpace = new HashMap<String,String>();
	
	public XmlStringParser(String XmlString) {
		this.XmlString = XmlString;
	}

	public void Load(){
		if(XmlString.length()!=0){	
			InputStream in = null; 			
			try {
				in =new ByteArrayInputStream(XmlString.getBytes("UTF-8"));
				SAXReader sax = new SAXReader();

				if(!nameSpace.isEmpty()){sax.getDocumentFactory().setXPathNamespaceURIs(nameSpace);}
				super.document = sax.read(in);
				
			}catch (UnsupportedEncodingException e){} 
			 catch (DocumentException ex) {System.out.println();}
			
			finally{
				try {
					if(in!=null){
						in.close();
					}
				} catch (IOException ex){System.out.println();}
			}
			
		}else{
			System.out.println();
		}
	}
	

	public Map<String,String>getNameSpace(){
		return nameSpace;
	}
	

	public void addNameSpace(String key,String value){
		nameSpace.put(key, value);
	}
	

	public void deleteNameSpace(String key){
		
		for(String k:nameSpace.keySet()){
			if(k.equals(key)){
				nameSpace.remove(key);
			}else System.out.println("");
		}
	}
	

	public void updateNameSpace(String key,String newValue){
		
		for(String k:nameSpace.keySet()){
			if(k.equals(key)){
				nameSpace.put(key, newValue);
			}else System.out.println("");
		}
	}
	

	public void clearNameSpace(){
		nameSpace.clear();
	}
	
}

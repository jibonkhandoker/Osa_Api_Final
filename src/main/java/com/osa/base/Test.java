package com.osa.base;


import com.osa.utility.Utils;


import io.restassured.response.Response;
import osa.com.request.Request;

public class Test {
	public static void main(String[] args) {
//		Properties prop=readPro("src//main//resources//properties//app.properties");
//		System.out.println(prop.getProperty("baseUrl"););
//		Properties props=readPro("src//main//resources//properties//test.properties");
//		System.out.println(props.getProperty("title"););
	//}
	//
	//public static Properties readPro(String path) {
//		Properties prop=new Properties();
//		try {
//			File file=new File(path);
//			FileInputStream fis=new FileInputStream (file);
//			prop.load(fis);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			
//		}
//		return prop;
		
		Response res=Request.sendRequest("GET", "/students/64a8be8e15dffde0c9211633",null);
		Utils util=new Utils(res);
		System.out.println(util.getValue("firstName"));
		System.out.println(util.getValue("lastName"));
		System.out.println(util.getValue("contractInfo.email"));
		System.out.println(util.getValue("aggrement.message"));
		
		 
	}
		

	}


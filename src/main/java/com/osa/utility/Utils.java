package com.osa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.json.JSONObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utils {
	Response res;
	public Utils (Response res) {
		this.res=res;
		res.prettyPrint();
	}
	
	
	public  String getValue(String xpath) {
		return res.getBody().jsonPath().getString(xpath).toString();
	}
	
	public JsonPath getJsonObect () {
		res.prettyPrint();
		JsonPath jp=res.getBody().jsonPath();
		return jp;
	}

 public static String getPayload (String fn, String ln, String dob, String email, String phone, boolean YesOrNo, String message) {
		 
		JSONObject jo=new JSONObject();
			jo.put("firstName", fn);
			jo.put("lastName", ln);
			jo.put("dob",dob);
			 
		JSONObject ci=new JSONObject();
			ci.put("email", email);
			ci.put("phone", phone);
			jo.put("contractInfo", ci);  
			
		JSONObject at=new JSONObject();
			at.put("agree", YesOrNo);
			at.put("message", message);
			jo.put("aggrement", at);
			
			return jo.toString();
	 }
 
 public static Properties readPro(String path) {
		Properties prop=new Properties();
		try {
			File file=new File(path);
			FileInputStream fis=new FileInputStream (file);
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return prop;
}


 }



package osa.com.request;

import java.util.Properties;

import com.osa.utility.Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Request {
	public static Response sendRequest(String req, String endpoint, String payload) {
		Response res=null;
			if (req.toLowerCase().equals("get")) {
			res=GET(endpoint);
		}	else if (req.toLowerCase().equals("post")) {
			res=POST(endpoint, payload );
		}else if (req.toLowerCase().equals("patch")) {
			 res=PATCH(endpoint, payload );
		}else if (req.toLowerCase().equals("delete")) {
		res=DELETE(endpoint);
		}else {
			System.out.println("enter the request type one of the following");
			System.out.println("[GET,POST,DELETE,PATCH]");
		}
			return res;
			
			
		}
		
		
		public static Response DELETE(String endpoint) {
			System.out.println("sending a DELETE request to"+ endpoint);
			
			RestAssured.baseURI ="https://osa-qa-app.herokuapp.com";
//			RequestSpecification request = RestAssured.given()
//					.auth()
//					.preemptive()
//					.basic("user", "pass")
//					.header("Content-type", "application/json");
			RequestSpecification req=Request.setRequest();	
			Response res=req.delete(endpoint);
			return res;
		} 
		public static Response PATCH(String endpoint, String payload) {
			System.out.println("sending a PATCH request to"+ endpoint);
			
			RestAssured.baseURI ="https://osa-qa-app.herokuapp.com";
//			RequestSpecification request = RestAssured.given()
//					.auth()
//					.preemptive()
//					.basic("user", "pass")
//					.header("Content-type", "application/json")
//					.body(payload);
			RequestSpecification req=Request.setRequest().body(payload);
			Response res=req.patch(endpoint);
			return res;
		} 
		
		public static Response POST(String endpoint, String payload) {
			System.out.println("sending a POST request to"+ endpoint);
			
			RestAssured.baseURI ="https://osa-qa-app.herokuapp.com";
//			RequestSpecification request = RestAssured.given()
//					.auth()
//					.preemptive()
//					.basic("user", "pass")
//					.header("Content-type", "application/json")
//					.body(payload);

			RequestSpecification req=Request.setRequest().body(payload);
		Response res=req.post(endpoint);
			return res;
		} 
		
		public static Response GET(String endpoint) {
			System.out.println("sending a GET request to"+ endpoint);
			
			RestAssured.baseURI ="https://osa-qa-app.herokuapp.com";
//			RequestSpecification request = RestAssured
//					.given()
//					.auth()
//					.preemptive()
//					.basic("user", "pass")
//			        .header("Content-type", "application/json");

			RequestSpecification req=Request.setRequest();
			Response res=req.get(endpoint);
			return res;
		} 
		
		public static RequestSpecification setRequest() {
			
			Properties prop=Utils.readPro("src//main//resources//properties//app.properties");
			RestAssured.baseURI =prop.getProperty("baseUrl");
			RequestSpecification request = RestAssured
					.given()
					.auth()
					.preemptive()
					.basic(prop.getProperty("username"), prop.getProperty("password"))
			        .header("Content-type", "application/json");
			
			return request;
			
		}
	}



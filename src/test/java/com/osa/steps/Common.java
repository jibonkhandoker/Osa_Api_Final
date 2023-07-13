package com.osa.steps;

import java.util.List;

import org.testng.Assert;

import com.osa.request.Requests;
import com.osa.utils.Utilis;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class Common {
	@Given("I have completed the authenticattion")
	public void i_have_completed_the_authenticattion() {
	    
	}

//	@When("I sent a {string} request to {string}")
//	public void i_sent_a_request_to(String reqType, String endpoint) {
//
//	 Response res=Requests.sendRequest(reqType,endpoint);
//	 Utilis Utilis=new Utilis(res);
	 
	//}
	@When("I sent a {string} request to {string}")
	public void i_sent_a_request_to(String reqType, String endpoint, io.cucumber.datatable.DataTable dataTable) {
		
		String   payload=Utilis.getPayload("Amir","Khan","01-01-1995","myemail@gmail.com","62536875874",true,"i agree all the rules and condition from OSA consulting Tech Corp");
		Response res=Requests.sendRequest(reqType,endpoint,payload);
	 Utilis Utilis=new Utilis(res);
		
	List<List<String>>dt=dataTable.asLists();
//	if (dt.get(0).get(0).toLowerCase().equals("v")) {
		System.out.println("Expected status Code"+ dt.get(0).get(2));
		System.out.println("Actual status Code"+ res.getStatusCode());
		Assert.assertEquals(String.valueOf(res.getStatusCode()), dt.get(0).get(2));
		
//	}

	    
	}
	
	
	@Then("I verify the following fields")
	public void i_verify_the_following_fields() {
	    
	}
}


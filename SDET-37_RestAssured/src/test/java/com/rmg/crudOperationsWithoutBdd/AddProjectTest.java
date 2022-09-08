package com.rmg.crudOperationsWithoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest {

	@Test
	public void Create()
	{
		//create Json object
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Nayana");
		jobj.put("projectName", "FirmaA1");
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 8);
		
		// preconditions request body and contenttype 
		RequestSpecification reqSpc = RestAssured.given();
		reqSpc.contentType(ContentType.JSON);
		reqSpc.body(jobj);
		
		//getting response and validation of response 
		Response resp = reqSpc.post("http://localhost:8084/addProject");
		ValidatableResponse validateResp = resp.then();
		validateResp.assertThat().contentType(ContentType.JSON);
		validateResp.assertThat().statusCode(201);
		validateResp.log().all();
		
		
		
		
	}
	
}

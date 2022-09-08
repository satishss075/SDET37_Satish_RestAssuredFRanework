package com.rmg.crudOperationsWithoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateTheProjectTest {
	@Test
	public void Update()
	{
		//create a Json object for put 
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "santosh");
		jobj.put("projectName", "zabilluh");
		jobj.put("status", "complted");
		jobj.put("teamSize", 18);
		
		//request body and content type 
		RequestSpecification respec = RestAssured.given();
		respec.contentType(ContentType.JSON);
		respec.body(jobj);
		
		// put action 
		  Response response = respec.put("http://localhost:8084/projects/TY_PROJ_825");
		// validation 
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();
		
		
	}

}

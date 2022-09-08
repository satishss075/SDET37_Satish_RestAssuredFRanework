package com.rmg.responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class staticResponseValidationTest {
	@Test
	public void StaticValidation() {
		
		String expData = "TY_PROJ_1203";
		baseURI = "http://localhost";
		port=8084;
		
		Response resp = when().get("/projects");
		String actual = resp.jsonPath().get("[1].projectId");
		
		resp.then().assertThat().statusCode(200);
		resp.then().assertThat().log().all();
		
		System.out.println(actual);
		Assert.assertEquals(expData, actual);
		System.out.println("data verified");
		
		Object resp1 = resp.jsonPath().get("[1]");
		System.out.println(resp1.toString());
		
	     
		
	}

}

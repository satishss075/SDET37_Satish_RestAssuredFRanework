package com.rmg.crudOperationsWithoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class getAllProjectsTest {
	
	@Test
	public void getAllProject()
	{
		Response response = RestAssured.get("http://localhost:8084/projects");
		ValidatableResponse validate = response.then();
		validate.assertThat().statusCode(200);
		validate.log().all();
	}

}

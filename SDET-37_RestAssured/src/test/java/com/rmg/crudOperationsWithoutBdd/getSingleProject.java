package com.rmg.crudOperationsWithoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class getSingleProject {
	@Test
	public void getSingleProjec()
	{
		Response response = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1002");
		ValidatableResponse validate = response.then();
		validate.statusCode(200);
		
		validate.log().all();
	}

}

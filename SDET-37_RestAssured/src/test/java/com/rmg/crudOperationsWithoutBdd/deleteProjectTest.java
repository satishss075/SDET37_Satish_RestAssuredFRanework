package com.rmg.crudOperationsWithoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class deleteProjectTest {
	@Test
	public void delete()
	{
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1007");
		response.then().assertThat().statusCode(204);
		response.then().log().all();
	}

}

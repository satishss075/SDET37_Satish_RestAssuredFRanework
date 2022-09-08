package com.rmg.parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class pathParameterTest {
	@Test
	public void pathParam() {
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.pathParam("Pid","TY_PROJ_1202" )
		.when()
		.get("/projects/{Pid}")
		.then().log().all();
		System.out.println("success");
		
	}

}

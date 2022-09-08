package com.rmg.parameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class queryParamTest {
	@Test
	public void queryParam() {
		baseURI="https://reqres.in";
		given()
		.queryParam("page", 3)
		.when()
		.get("/api/users")
		.then()
		.log().all();
	
				
	}

}

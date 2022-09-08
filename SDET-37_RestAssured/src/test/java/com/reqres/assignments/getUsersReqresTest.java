package com.reqres.assignments;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class getUsersReqresTest {
	@Test
	public void get() {
		baseURI="https://reqres.in";
		given()
		.get("/api/users?page=2")
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
		
		
	}

}

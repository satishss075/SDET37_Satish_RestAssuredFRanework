package com.reqres.assignments;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createUserUsingBddReqresTest {
	@Test
	public void create() {
		
		Random ran = new Random();
		int number = ran.nextInt(100);
		
		baseURI="https://reqres.in";
		JSONObject obj = new JSONObject();
		obj.put("name", "mahadev"+number);
		obj.put("job", "bhajana");
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.post("/api/users")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
		
		
		
	}

}

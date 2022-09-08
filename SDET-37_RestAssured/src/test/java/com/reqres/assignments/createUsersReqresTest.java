package com.reqres.assignments;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class createUsersReqresTest {
	@Test
	public void create() {
		
		Random ran = new Random();
		int number = ran.nextInt(100);
		JSONObject obj = new JSONObject();
		obj.putIfAbsent("name", "abcd"+number);
		obj.putIfAbsent("job", "trainee");
		
		RequestSpecification rest = RestAssured.given();
		rest.body(obj);
		rest.contentType(ContentType.JSON);
		
		Response response = rest.post("https://reqres.in/api/users");
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();
		
	}

}

package com.rmg.autentications;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2Test {
	@Test
	public void auth2()
	{
		Response response = given()
		.formParam("client_id", "Sdet37_rest")
		.formParam("client_secret", "6b53eef3b8010c94ec866c85c77b38ac")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://restSdet@.com")
		.formParam("code", "authorization_code")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		String token = response.jsonPath().get("access_token");
		
		System.out.println(token);
		
		given()
		.auth().oauth2(token)
		.pathParam("userid", 3748)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{userid}/eggs-collect")
		.then().log().all();
		
	}

}

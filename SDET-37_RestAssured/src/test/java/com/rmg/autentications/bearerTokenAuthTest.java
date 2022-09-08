package com.rmg.autentications;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class bearerTokenAuthTest {
	@Test
	public void bearerToken() {
		
		JSONObject obj = new JSONObject();
		obj.put("name", "sahara");
		

		baseURI="https://api.github.com";
		
		given()
		.auth()
		.oauth2("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")
		.body(obj)
		
		.when()
		.post("/user/repos")
		
		.then()
		.log().all();
		
		
		
	}

}

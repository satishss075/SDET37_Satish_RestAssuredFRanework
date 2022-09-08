package com.rmg.autentications;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class diffrentWaysOfBasicAuthTest {
	@Test
	public void PreemtiveAuth() {
		
		baseURI="http://localhost";
		port = 8084;
		
		//preconditions
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		
		//actions 
		.when()
		.get("/login")
		
		//validations
		.then().assertThat().statusCode(202)
		.time(Matchers.lessThan(9000L),TimeUnit.MILLISECONDS)
		.log().all();
	}
	
	@Test
	public void digestAuth() {
		
		baseURI="http://localhost";
		port=8084;
		
		//pre-conditions
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		
		//actions
		.when()
		.get("/login")
		
		//validations
		.then().assertThat().statusCode(202)
		.time(Matchers.lessThan(9000L),TimeUnit.MILLISECONDS)
		.log().all();
	}

}

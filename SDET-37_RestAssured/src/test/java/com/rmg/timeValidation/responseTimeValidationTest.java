package com.rmg.timeValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class responseTimeValidationTest {
	@Test
	public void responseTime() {
		
		baseURI="http://localhost";
		port=8084;
		
		when()
		.get("/projects")
		.then().assertThat().time(Matchers.lessThan(9000L),TimeUnit.MILLISECONDS)
	    .assertThat().statusCode(200)
		.log().all();
		
	}

}

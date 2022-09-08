package com.rmg.request.chaining;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassForSerializationAndDeserialization.pojoClassForAddProject;

public class postAndPutTest {
	@Test
	public void requesChaining3() {

		 com.crm.genericUtilities.JavaUtility jlib = new com.crm.genericUtilities.JavaUtility();
		int number = jlib.getRandomNumber();
		
		pojoClassForAddProject pojoObj = new pojoClassForAddProject("mahesh", "swami"+number, "complted", "95");
		baseURI = "http://localhost";
		port=8084;
		
		Response resp = given()
		.body(pojoObj)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		String proid = resp.jsonPath().get("projectId");
		System.out.println(proid);
		resp.then().log().all();
		
		
		
		pojoClassForAddProject pojoObj1 = new pojoClassForAddProject("nagesh", "panchal"+number, "completed", "65");
		
		given()
		.pathParam("pid",proid )
		.body(pojoObj1)
		.contentType(ContentType.JSON)
		.when()
		.put("/projects/{pid}")
		.then().assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200).log().all();
		
		
		
	}

}

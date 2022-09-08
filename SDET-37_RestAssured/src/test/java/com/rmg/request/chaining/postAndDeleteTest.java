package com.rmg.request.chaining;



import com.crm.genericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassForSerializationAndDeserialization.pojoClassForAddProject;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class postAndDeleteTest {
	@Test
	public void requesttChaining2() {
		
		com.crm.genericUtilities.JavaUtility jlib = new com.crm.genericUtilities.JavaUtility();
		int number = jlib.getRandomNumber();
		
		pojoClassForAddProject pojoObj = new pojoClassForAddProject("sandesh", "gnagal"+number, "ongoing", "95");
		baseURI = "http://localhost";
		port=8084;
		
		Response resp = given()
		.body(pojoObj)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		String proid = resp.jsonPath().get("projectId");
		System.out.println(proid);
		
		Response resp1 = given()
		.pathParam("pid", proid)
		.when()
		.delete("/projects/{pid}");
		
		resp1.then().assertThat().statusCode(204);
		
	
		
	}

}

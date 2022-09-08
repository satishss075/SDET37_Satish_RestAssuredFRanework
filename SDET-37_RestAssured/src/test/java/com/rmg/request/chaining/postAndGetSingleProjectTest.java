package com.rmg.request.chaining;



import com.crm.genericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.pojoClassForAddProject;

public class postAndGetSingleProjectTest {
	@Test
	public void requestChaining() {
	 com.crm.genericUtilities.JavaUtility jlib = new com.crm.genericUtilities.JavaUtility() ;
	int number = jlib.getRandomNumber();
	pojoClassForAddProject pojo = new pojoClassForAddProject("manoj", "udgire"+number, "completed", "85");
	baseURI="http://localhost";
	port=8084;
	
		
	Response resp = given()
	.body(pojo)
	.contentType(ContentType.JSON)
	.when()
	.post("/addProject");
	
	//capture the project id from post response
	String proId = resp.jsonPath().get("projectId");
	
	System.out.println(proId);
	
	//resp.then().log().all();
	
	
	//get request by using path parameter
	Response resp1 = given()
	.pathParam("pid", proId)
	.when()
	.get("/projects/{pid}");
	
	resp1.prettyPrint();
	resp1.getTime();
	
//	
	
		
	}

}

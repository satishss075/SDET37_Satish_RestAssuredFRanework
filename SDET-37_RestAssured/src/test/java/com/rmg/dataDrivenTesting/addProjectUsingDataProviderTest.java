package com.rmg.dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

import pojoClassForSerializationAndDeserialization.pojoClassForAddProject;

public class addProjectUsingDataProviderTest {
	@Test(dataProvider = "dataProvide")
	public void create(String createdBy,String projectName,String status,String teamSize )
	{
		pojoClassForAddProject pojo = new pojoClassForAddProject(createdBy, projectName, status, teamSize);
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
		
	}
		
	 
	@DataProvider
	 public Object[][] dataProvide()
	 {
		Random ran = new Random();
		int num = ran.nextInt(100);
		  Object[][] array = new Object[1][4];
		  array[0][0]="maharaja";
		  array[0][1]="shivanand"+num;
		  array[0][2]="completed";
		  array[0][3]=1;
		  return array;
		 
	 }
	
	
	
}


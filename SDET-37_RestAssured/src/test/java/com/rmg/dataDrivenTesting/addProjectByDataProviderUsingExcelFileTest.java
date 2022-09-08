package com.rmg.dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Excel.excelUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

import pojoClassForSerializationAndDeserialization.pojoClassForAddProject;

public class addProjectByDataProviderUsingExcelFileTest extends excelUtility {
	
	
	@Test(dataProvider = "bodyData")
	public void create(String createdBy,String projectName,String status,String teamSize) {
		pojoClassForAddProject pojoExcel = new pojoClassForAddProject(createdBy, projectName, status, teamSize);
		given()
		.body(pojoExcel)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
		
	}
	@DataProvider
	public Object[][] bodyData() throws Throwable{
		
		Random ran = new Random();
		int ranNum = ran.nextInt(100);
		Object[][] array = new Object[4][4];
		
		array[0][0]=getDataFromExcel("Sheet1", 1, 0);
		array[0][1]=getDataFromExcel("Sheet1", 1, 1)+ranNum;
		array[0][2]=getDataFromExcel("Sheet1", 1, 2);
		array[0][3]=getDataFromExcel("Sheet1", 1, 3);
		array[1][0]=getDataFromExcel("Sheet1", 2, 0);
		array[1][1]=getDataFromExcel("Sheet1", 2, 1)+ranNum;
		array[1][2]=getDataFromExcel("Sheet1", 2, 2);
		array[1][3]=getDataFromExcel("Sheet1", 2, 3);
		array[2][0]=getDataFromExcel("Sheet1", 3, 0);
		array[2][1]=getDataFromExcel("Sheet1", 3, 1)+ranNum;
		array[2][2]=getDataFromExcel("Sheet1", 3, 2);
		array[2][3]=getDataFromExcel("Sheet1", 3, 3);
		array[3][0]=getDataFromExcel("Sheet1", 4, 0);
		array[3][1]=getDataFromExcel("Sheet1", 4, 1)+ranNum;
		array[3][2]=getDataFromExcel("Sheet1", 4, 2);
		array[3][3]=getDataFromExcel("Sheet1", 4, 3);
		return array;
		
	}

}

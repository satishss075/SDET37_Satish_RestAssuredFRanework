package com.crm.genericUtilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredLibrary {
	
	
	public String getJsonPath(Response response,String path)
	{
		String project = response.jsonPath().get(path);
		return project;
		
	}
	

}

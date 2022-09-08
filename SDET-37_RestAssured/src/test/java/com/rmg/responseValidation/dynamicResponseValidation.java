package com.rmg.responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.List;

public class dynamicResponseValidation {
	@Test
	public void dynamicVAlidation() {
		
		String expectedData1 = "satish213";
		baseURI="http://localhost";
		port=8084;
		
		Response resp = when().get("/projects");
		resp.then().log().all();
		List<String> pids = resp.jsonPath().get("projectName");
		
		System.out.println(pids);
		
		boolean flag = false;
		
		for (String projectId : pids) 
		{
			if (projectId.equalsIgnoreCase(expectedData1))
			{
				System.out.println("ProjectName is Matching");
				flag=true;
			} 

		}
		
		Assert.assertTrue(flag);
		System.out.println(" ");
		
		System.out.println("ProjectName is verified successfully");
		
		
		
	}
	

}

package com.rmg.request.chaining;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.crm.genericUtilities.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassForSerializationAndDeserialization.pojoClassForAddProject;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

public class postGetPuteDeleteJdbcGuiVerifyTest {
	@Test 
	public void requestChainingAndVerify() throws SQLException {
		
		com.crm.genericUtilities.JavaUtility jlib = new com.crm.genericUtilities.JavaUtility();
		pojoClassForAddProject pojoObj = new pojoClassForAddProject("shivanand", "manohar"+jlib.getRandomNumber(), "completed", "10");
		
		Response response = given()
		.body(pojoObj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject");
		
		String projId = response.jsonPath().get("projectId");
		System.out.println(projId);
		
		given()
		.pathParam("pid1", projId)
		.when()
		.get("http://localhost:8084/projects/{pid1}")
		.then()
		.log().all();
		
		pojoClassForAddProject pojoObj1 = new pojoClassForAddProject("manohar", "shivanand"+jlib.getRandomNumber(), "ongoing", "12");
		
		given()
		.pathParam("pid2",projId )
		.body(pojoObj1)
		.contentType(ContentType.JSON)
		.when()
		.put("http://localhost:8084/projects/{pid2}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
		given()
		.pathParam("pid3",projId )
		.when()
		.delete("http://localhost:8084/projects/{pid3}")
		.then().log().all();
		
		
		// database verification
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("select * from project");
		boolean flag = false;
		
		while (result.next()) 
		{
			if (result.getString(1).contains(projId))
			{
				flag=true;
				break;
			}
			if (flag==true) 
			{
				System.out.println("project is not deleted from database");
			} else {
				System.out.println("project is deleted from database successfully");

			}
			conn.close();
		
			//GUI verification
			WebDriver driver = WebDriverManager.chromedriver().create();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
			driver.get("http://localhost:8084/");
			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
			driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[.='Sign in']")).click();
			driver.findElement(By.xpath("//a[.='Projects']")).click();
			List<WebElement> projectIds = driver.findElements(By.xpath("//tr//td[1]"));
			for (WebElement id : projectIds) {

				String proId = id.getText();
				boolean flag1=false;
				if (proId.equalsIgnoreCase(projId)) {
					flag1=true;
				}
			}
			if (flag==true) {
				System.out.println("Project is not Deleted From RMG!");
			}
			else {
				System.out.println("Project is Deleted From RMG!");
                   break;
			}
			
			
			
		}
		
		
	}

}

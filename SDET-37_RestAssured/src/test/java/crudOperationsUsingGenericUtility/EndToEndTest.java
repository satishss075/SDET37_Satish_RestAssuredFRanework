package crudOperationsUsingGenericUtility;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.genericUtilities.BaseApiClass;
import com.crm.genericUtilities.DataBaseUtility;
import com.crm.genericUtilities.EndPointsLibrary;
import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.RestAssuredLibrary;
import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassForSerializationAndDeserialization.pojoClassForAddProject;

public class EndToEndTest {

	@Test 
	public void requestChainingAndVerify() throws SQLException {

		baseURI="http://localhost";
		port =8084;
		com.crm.genericUtilities.JavaUtility jlib = new com.crm.genericUtilities.JavaUtility();
		pojoClassForAddProject pojoObj = new pojoClassForAddProject("sachin", "manohar"+jlib.getRandomNumber(), "completed", "10");

		Response response = given()
				.body(pojoObj)
				.contentType(ContentType.JSON)
				.when()
				.post(EndPointsLibrary.createProject);

		RestAssuredLibrary rlib = new RestAssuredLibrary();
		String projId = rlib.getJsonPath(response, "projectId");
		System.out.println(projId);

		// database verification
		BaseApiClass base = new BaseApiClass();
		base.dbConnect();
		DataBaseUtility dLib=new DataBaseUtility();
		dLib.execuiteQuery("select * from project", 1, projId);


		//GUI verification
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get(IConstants.uri);
		driver.findElement(By.id("usernmae")).sendKeys(IConstants.appUsername);
		driver.findElement(By.id("inputPassword")).sendKeys(IConstants.appPassword);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		List<WebElement> projectIds = driver.findElements(By.xpath("//tr//td[1]"));
		boolean flag=false;

		for (WebElement id : projectIds) {

			String proId = id.getText();

			if (proId.equalsIgnoreCase(projId)) {
				flag=true;
			}
		}


		if (flag==true) {

			System.out.println("Project is successfully created in RMG!");
		}
		else {

			System.out.println("Project is not created in RMG!");

		}

		given()
		.pathParam("pid3",projId )
		.when()
		.delete(EndPointsLibrary.deleteProject+"{pid3}")
		.then().log().all();

		dLib.execuiteQuery("select * from project", 1, projId);


		WebDriver driver1 = WebDriverManager.chromedriver().create();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver1.get(IConstants.uri);
		driver1.findElement(By.id("usernmae")).sendKeys(IConstants.appUsername);
		driver1.findElement(By.id("inputPassword")).sendKeys(IConstants.appPassword);
		driver1.findElement(By.xpath("//button[.='Sign in']")).click();
		driver1.findElement(By.xpath("//a[.='Projects']")).click();
		List<WebElement> projectIds1 = driver1.findElements(By.xpath("//tr//td[1]"));
		boolean flag1=false;

		for (WebElement id : projectIds1) {

			String proId = id.getText();

			if (proId.equalsIgnoreCase(projId)) {
				flag1=true;
			}
		}


		
		if (flag1) {
			
			System.out.println("project is not deleted");
		}
		else {

			System.out.println("Project is  deleted in RMG!");

		}





	}




}


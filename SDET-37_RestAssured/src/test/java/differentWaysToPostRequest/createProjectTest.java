package differentWaysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoClassForSerializationAndDeserialization.pojoClassForAddProject;

public class createProjectTest {
	@Test
	public void createProject (){
		
		pojoClassForAddProject addProject = new pojoClassForAddProject("satishss", "bidar075", "completed", "85");
		given()
		.contentType(ContentType.JSON)
		.body(addProject)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201).log().all();
		
	}
	
		
		
		
	}



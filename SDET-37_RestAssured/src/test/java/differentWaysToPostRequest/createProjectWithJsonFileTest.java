package differentWaysToPostRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createProjectWithJsonFileTest {
	
	@Test
	public void create() {
		File file = new File("./src/test/resources/bdd.json");
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
	}

}

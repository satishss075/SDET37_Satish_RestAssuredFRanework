package CrudOperationsWithBdd;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class getSingleProjectTest {
	@Test
	public void getSingleProject() {
		given()
		.get("http://localhost:8084/projects/TY_PROJ_822")
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
		
	}

}

package CrudOperationsWithBdd;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class deleteProjectTest {
	@Test
	public void deleteProject() {
	 given()
		.when()
		.delete("http://localhost:8084/projects/TY_PROJ_1202")
		
		.then().assertThat()
		.contentType(ContentType.JSON)
		.statusCode(204)
		.time(Matchers.lessThan(2000L))
		.log().all();
	}

}

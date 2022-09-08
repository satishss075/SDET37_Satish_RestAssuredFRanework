package differentWaysToPostRequest;

import java.util.HashMap;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createProjectWithHashMapTest {
	@Test
	public void create() {
		Random ran = new Random();
		int no = ran.nextInt(100);
		HashMap hash = new HashMap();
		hash.put("createdBy", "sangamesh"+no);
		hash.put("projectName", "kashinath"+no);
		hash.put("status", "completed");
		hash.put("teamSize", 87);
		
		
		given()
		.body(hash)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}
}

package differentWaysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoClassForSerializationAndDeserialization.pojoClassForJsonObject;

public class createProjectWithJsonObject {
	@Test
	public void create() {
		pojoClassForJsonObject jsonObject1 = new pojoClassForJsonObject();
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObject1.jsonObject())
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
				
	}	

}

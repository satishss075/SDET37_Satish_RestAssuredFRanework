package CrudOperationsWithBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class createProjectTest {
	@Test
	public void create() {

		Random ran = new Random();
		int ranNum = ran.nextInt(500);
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "ganesha");
		
		jobj.put("projectName", "festival"+ranNum);
		jobj.put("status", "created");
		jobj.put("teamSize", 15);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201).log().all();
	
	}

}

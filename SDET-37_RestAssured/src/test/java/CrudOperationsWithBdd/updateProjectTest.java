package CrudOperationsWithBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class updateProjectTest {
	@Test
	public void UpdateProject() {
		
		Random ran = new Random();
		int ranNum = ran.nextInt(500);
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "mahadev");
		jobj.put("projectName", "parvati"+ranNum);
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 65);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_822")
		.then().assertThat().contentType(ContentType.JSON)
		.statusCode(200).log().all();
		
		
	}

}

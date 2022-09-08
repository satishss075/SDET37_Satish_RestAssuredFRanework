package pojoClassForSerializationAndDeserialization;

import java.util.Random;

import org.json.simple.JSONObject;

public class pojoClassForJsonObject {
	
	
public Object jsonObject() {
	Random ran = new Random();
	int ranNum = ran.nextInt(100);
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "mahalappa");
	jobj.put("projectName", "sai"+ranNum);
	jobj.put("status", "completed");
	jobj.put("teamSize", 85);
	return jobj;
}
}

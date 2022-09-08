package SerializationAndDesrialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoClassForSerializationAndDeserialization.Employee;
import pojoClassForSerializationAndDeserialization.Spouse;

public class EmployeeSerializationWithSpouse {

	public static void main(String[] args) throws IOException, JsonMappingException, IOException   {
		// TODO Auto-generated method stub
		int[] mobileNo= {78589456,84517689};
		Spouse objSpouse = new Spouse("rohini", "diggi123", "rohni@gmail.com", mobileNo);
Employee emp = new Employee(12345, "Satish", "sss075", "satish@gmail.com",objSpouse);
ObjectMapper obj = new ObjectMapper();
obj.writeValue(new File("./Spouse3.json"),emp);

	}

}

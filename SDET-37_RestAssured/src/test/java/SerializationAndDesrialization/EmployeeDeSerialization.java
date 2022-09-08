package SerializationAndDesrialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoClassForSerializationAndDeserialization.Employee;

public class EmployeeDeSerialization {

	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		// TODO Auto-generated method stub
		ObjectMapper objMapper1 = new ObjectMapper();
		Employee des = objMapper1.readValue(new File("./Employee.json"), Employee.class);
       System.out.println(des.getEmail()+"/t"+des.getEmpId()+"/t"+des.getEmpName()+"/t"+des.getPhoneNo());
	}

}

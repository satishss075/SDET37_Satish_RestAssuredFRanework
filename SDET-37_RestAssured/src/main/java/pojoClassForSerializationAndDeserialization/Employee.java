package pojoClassForSerializationAndDeserialization;

public class Employee 
{
String empName;
String empId;
String email;
int phoneNo;
Spouse spouse;

//constructor to initialize elements
public Employee (int phoneNo,String empName, String empId ,String email, Spouse spouse )
{
	this.phoneNo = phoneNo;
	this.empName=empName;
	this.empId=empId;
	this.email=email;
	this.spouse=spouse;
}

//constructor calling
Employee()
{
	
}


public Spouse getSpouse() {
	return spouse;
}



public void setSpouse(Spouse spouse) {
	this.spouse = spouse;
}





// utilization

public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public String getEmpId() {
	return empId;
}

public void setEmpId(String empId) {
	this.empId = empId;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(int phoneNo) {
	this.phoneNo = phoneNo;
}



}

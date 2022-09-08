package pojoClassForSerializationAndDeserialization;

public class EmployeeArray {
	String empName;
	String empId;
	String[] emailId;
	int[] phoneNo;
	
	public EmployeeArray(String empName, String empId,String[] emailId,int[] phoneNo )
	{
		this.empName=empName;
		this.empId=empId;
		this.emailId=emailId;
		this.phoneNo=phoneNo;
	}
	EmployeeArray()
	{
		
	}
	
	public int[] getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int[] phoneNo) {
		this.phoneNo = phoneNo;
	}
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
	public String[] getEmailId() {
		return emailId;
	}
	public void setEmailId(String[] emailId) {
		this.emailId = emailId;
	}
	
	
	
	

}

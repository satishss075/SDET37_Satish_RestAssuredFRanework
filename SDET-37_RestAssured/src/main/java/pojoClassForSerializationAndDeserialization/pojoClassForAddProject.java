package pojoClassForSerializationAndDeserialization;

import java.util.Random;

public class pojoClassForAddProject {
	
	String createdBy;
	String projectName;
	String status;
	String teamSize;
	
	public pojoClassForAddProject(String createdBy,String projectName,String status,String teamSize) {
		Random ran = new Random();
		int ranNum = ran.nextInt(50);
		this.createdBy=createdBy;
		this.projectName =projectName+ranNum;
		this.status=status;
		this.teamSize=teamSize;
	}
	pojoClassForAddProject()
	{
		
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(String teamSize) {
		this.teamSize = teamSize;
	}
	
	

}

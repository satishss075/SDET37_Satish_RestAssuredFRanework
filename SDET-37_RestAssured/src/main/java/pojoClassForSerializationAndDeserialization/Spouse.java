package pojoClassForSerializationAndDeserialization;

public class Spouse {
     String spouseName;
     String spouseId;
     String spouseEmailId;
     int[] mobileNo;
     
     public Spouse(String spouseName,String spouseId,String spouseEmailId,int[] mobileNo  )
     {
    	 this.spouseName=spouseName;
    	 this.spouseId=spouseId;
    	 this.spouseEmailId=spouseEmailId;
    	 this.mobileNo=mobileNo;
    }
     Spouse(){
    	 
     }
	public String getSpouseName() {
		return spouseName;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	public String getSpouseId() {
		return spouseId;
	}
	public void setSpouseId(String spouseId) {
		this.spouseId = spouseId;
	}
	public String getSpouseEmailId() {
		return spouseEmailId;
	}
	public void setSpouseEmailId(String spouseEmailId) {
		this.spouseEmailId = spouseEmailId;
	}
	public int[] getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int[] mobileNo) {
		this.mobileNo = mobileNo;
	}
     
     
     
     

}

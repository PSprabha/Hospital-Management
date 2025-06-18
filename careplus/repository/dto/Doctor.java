package careplus.repository.dto;

public class Doctor {

	private int id;
	private String name;
	private String mobNum;
	private String specialist;
	private int startTime;
	private int endTime;
	private int appoinmentCount;
	
	// when the doctor's visiting time was ended... then the receptionist set the appointment count = 0
	// doctors are available in all days
	
	public Doctor(int id,String name, String mobNum, String specialist, int startTime, int endTime, int appoinmentCount) {
		
		this.id = id;
		this.name = name;
		this.mobNum = mobNum;
		this.specialist = specialist;
		this.startTime = startTime;
		this.endTime = endTime;
		this.appoinmentCount = appoinmentCount;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobNum() {
		return mobNum;
	}
	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getAppoinmentCount() {
		return appoinmentCount;
	}
	public void setAppoinmentCount(int appoinmentCount) {
		this.appoinmentCount = appoinmentCount;
	}
	
	
}

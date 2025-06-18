package careplus.repository.dto;

public class Patient {
	int id;
	String name;
	String mobNum;
	int age;
	String location;
	
	
	public Patient(int id, String name,String mobNum, int age, String location) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.location = location;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobNum() {
		return mobNum;
	}
	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}
	
}

package careplus.repository.dto;

public class Appointment {

	private int id;
	private int patientId;
	private int doctorId;
	private int time;
	private String date;
	
	public Appointment(int id, int patientId, int doctorId, int time, String date) {
		this.id = id;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.time = time;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}

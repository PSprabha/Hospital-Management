package careplus.repository.db;

import java.util.HashMap;

import careplus.repository.dto.Admin;
import careplus.repository.dto.Appointment;
import careplus.repository.dto.Doctor;
import careplus.repository.dto.Patient;
import careplus.repository.dto.Receptionist;

public class HospitalRepository 
{
	private static HospitalRepository repo;
	private static HashMap<Integer, Admin> admins;
	private static HashMap<Integer, Receptionist> receptionists;
	private static HashMap<Integer, Doctor> doctors;
	private static HashMap<String, Patient> patients;
	private static HashMap<Integer, Appointment> appoints;
	
	private HospitalRepository()
	{
		admins = new HashMap<Integer, Admin>();
		receptionists = new HashMap<Integer, Receptionist>();
		doctors = new HashMap<Integer, Doctor>();
		patients = new HashMap<String, Patient>();
		appoints = new HashMap<Integer, Appointment>();
	}
	
	public static HospitalRepository getInstance()
	{
		if(repo == null)
			repo = new HospitalRepository();
		
		return repo;
	}
	
	public void setAdmin(int id, Admin a)
	{
		admins.put(id, a);
	}
	
	public HashMap<Integer, Admin> getAllAdmin()
	{
		return this.admins;
	}
	
	public Admin getAdmin(int id)
	{
		return admins.get(id);
	}
	
	
	public void setReceptionists(int id, Receptionist r)
	{
		receptionists.put(id, r);
	}
	
	public HashMap<Integer, Receptionist> getAllReceptionists()
	{
		return this.receptionists;
	}
	
	public Receptionist getReceptionists(int id)
	{
		return receptionists.get(id);
	}
	
	public void setDoctors(int id, Doctor r)
	{
		doctors.put(id, r);
	}
	
	public HashMap<Integer, Doctor> getAllDoctors()
	{
		return this.doctors;
	}
	
	public Doctor getDoctors(int id)
	{
		return doctors.get(id);
	}
	
	public void setPatient(String mobNum, Patient r)
	{
		patients.put(mobNum, r);
	}
	
	public HashMap<String, Patient> getAllPatients()
	{
		return this.patients;
	}
	
	public Patient getPatients(String mobNum)
	{
		return patients.get(mobNum);
	}
	
	
	public void setAppointment(int id, Appointment a)
	{
		appoints.put(id, a);
	}
	
	public HashMap<Integer, Appointment> getAllAppointment()
	{
		return this.appoints;
	}
	
	public Appointment getAppointment(int id)
	{
		return appoints.get(id);
	}
}

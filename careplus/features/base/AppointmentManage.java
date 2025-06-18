package careplus.features.base;

import java.util.HashMap;
import java.util.Scanner;

import careplus.Main;
import careplus.features.receptionist.ReceptionistMain;
import careplus.repository.db.HospitalRepository;
import careplus.repository.dto.Appointment;
import careplus.repository.dto.Doctor;
import careplus.repository.dto.Patient;

public class AppointmentManage {

	private static int appointmentId = 1;
	private final Scanner scanner = new Scanner(System.in);
	private final HospitalRepository repo = HospitalRepository.getInstance();
	
	public void showMainMenu()
	{
		manageAppointment();
	}

	private void manageAppointment() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			System.out.println("\n *** manage appointments ***");
			System.out.println("1.  book appointment");
			System.out.println("2.  view by patient");
			System.out.println("3.  View by All Doctors");
			System.out.println("4.  View by Specify Doctors");
			System.out.println("5.  View All available slots of Doctors");
			System.out.println("6.  back to main menu");
			System.out.println("7.  logout");
			System.out.println("8.  Exit");
			
			
			try
			{
				int choice = Integer.parseInt(scanner.nextLine());
				
				switch(choice)
				{
				case 1:
					bookAppointment();
					break;
				case 2 :
					viewByPatient();
					break;
				case 3:
					viewByDoctors();
					break;
				case 4:
					specificDoctor();
					break;
				case 5 :
					availableSlotsOfSpecificDoctor();
					break;
				case 6:
					new BaseView().showMainMenu();
					break;
				case 7:
					new Main().main(new String[] {"care plus system..."});
					break;
				case 8:
					System.exit(0);
				default:
					System.out.println("Please enter valid choice...!");
				
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Please enter the valid number...!");
			}
		}
	}

	private void availableSlotsOfSpecificDoctor() {
		// TODO Auto-generated method stub
		HashMap<Integer, Doctor> doctors = repo.getAllDoctors();

		System.out.println("\n *** available slots of specific doctor*** \n");
		

		if(repo.getAllAppointment().isEmpty())
		{
			System.out.println("\n No appointments are booked... \n");
			return;
		}
		
		
		for(Doctor dr : doctors.values())
		{
			System.out.println("Doctor name ==> + "   + dr.getName());
			System.out.println("Doctor id ==> + "   + dr.getId());
			System.out.println();
		}
		
		int id = 0;
		while(true)
		{
			System.out.println("Enter the doctor id :");
			try {
				id = Integer.parseInt(scanner.nextLine());
				if(!doctors.containsKey(id))
					continue;
				break;
			}
			catch(NumberFormatException e)
			{
				System.out.println("Enter valid number");
			}
		}
		
		Doctor crnt = repo.getDoctors(id);
		
		System.out.println(crnt.getName() + " has available appointmens "+ crnt.getAppoinmentCount());
	}

	private void specificDoctor() {
		// TODO Auto-generated method stub

		System.out.println("\n *** specific doctor's appoinments *** \n");
		

		if(repo.getAllAppointment().isEmpty())
		{
			System.out.println("\n No appointments are booked... \n");
			return;
		}
		
		
		HashMap<Integer, Doctor> doctors = repo.getAllDoctors();
		
		for(Doctor dr : doctors.values())
		{
			System.out.println("Doctor name ==> + "   + dr.getName());
			System.out.println("Doctor id ==> + "   + dr.getId());
			System.out.println();
		}
		
		int id = 0;
		while(true)
		{
			System.out.println("Enter the doctor id :");
			try {
				id = Integer.parseInt(scanner.nextLine());
				if(!doctors.containsKey(id))
					continue;
				break;
			}
			catch(NumberFormatException e)
			{
				System.out.println("Enter valid number");
			}
		}
		
		System.out.println("Doctor name ==> " + repo.getDoctors(id).getName() + "appointments are..");
		for(Appointment a : repo.getAllAppointment().values())
		{
			if(a.getDoctorId()==id)
			{
				System.out.println("Doctor id ==>  " + a.getDoctorId());
				System.out.println("Date  ==>  " + a.getDate());
				System.out.println("time  ==>  " + a.getTime());
				System.out.println("appointment id  ==>  " + a.getId());
				System.out.println();
			}
		}
		
	}

	private void viewByDoctors() {
		// TODO Auto-generated method stub
		HashMap<Integer, Doctor> doctors = repo.getAllDoctors();
		HashMap<Integer, Appointment> appointments = repo.getAllAppointment();
		

		System.out.println("\n *** appointments of all doctors *** \n");
		

		if(repo.getAllAppointment().isEmpty())
		{
			System.out.println("\n No appointments are booked... \n");
			return;
		}
		
		
		for(Integer drID : doctors.keySet())
		{
			System.out.println("Doctor name ==> " + doctors.get(drID).getName());
			for(Appointment ap : appointments.values())
			{
				if(ap.getDoctorId() == drID)
				{
					System.out.println("appointment id ==> " + ap.getId());
					System.out.println("Date  ==>  " + ap.getDate());
					System.out.println("time  ==>  " + ap.getTime());
				}
			}
			System.out.println();
		}
	}

	private void viewByPatient() {
		// TODO Auto-generated method stub
		
		String mobNum;

		System.out.println("\n *** appointments of patient *** \n");
		
		if(repo.getAllAppointment().isEmpty())
		{
			System.out.println("\n No appointments are booked... \n");
			return;
		}
		
		do
		{
			System.out.println("Enter mobile number...");
			mobNum = scanner.nextLine();
		}
		while(!(validMobNum(mobNum.trim())));
		
		if(!repo.getAllPatients().containsKey(mobNum))
		{
			new PatientManage().addPatient();
		}
		
		int id = repo.getPatients(mobNum).getId();
		
		System.out.println("Patient name ==> " + repo.getPatients(mobNum).getName());
		System.out.println();
		
		for(Appointment a : repo.getAllAppointment().values())
		{
			if(a.getPatientId()==id)
			{
				System.out.println("Doctor id ==>  " + a.getDoctorId());
				System.out.println("Date  ==>  " + a.getDate());
				System.out.println("time  ==>  " + a.getTime());
				System.out.println();
			}
		}
	}

	private void bookAppointment() {
		// TODO Auto-generated method stub
		String mobNum;
		

		System.out.println("\n *** book appointment *** \n");
		
		do
		{
			System.out.println("Enter patient's mobile number...");
			mobNum = scanner.nextLine();
		}
		while(!(validMobNum(mobNum.trim())));
		
		if(!repo.getAllPatients().containsKey(mobNum))
		{
			System.out.println("\n Patient not yet registered...so add the patients credentials...\n");
			new PatientManage().addPatient();
		}
		
		Patient crnt = repo.getPatients(mobNum.trim());
		
		int drId = viewAllDoctors();
		Doctor dr = repo.getDoctors(drId);
		
		if(dr.getAppoinmentCount() <= 0)
		{
			System.out.println("No doctors are available...");
			return;
		}
		
		System.out.println("Enter the date of appointment... by this format...." + "dd/mm/yyyy");
		System.out.println();
		String date = scanner.nextLine();
		
		repo.setAppointment(appointmentId, new Appointment(appointmentId, crnt.getId(), drId, dr.getEndTime(), date));
		
		
		System.out.println("Appointment booked successfully...");
	}
	
	private int viewAllDoctors() {
		// TODO Auto-generated method stub

		System.out.println("\n *** all doctors lists *** \n");
		
		HashMap<Integer, Doctor> doctors = repo.getAllDoctors();
		boolean flg = true;
		
		for(Doctor dr : doctors.values())
		{
			if(dr.getAppoinmentCount() > 0)
			{
				System.out.println("name ==> " + dr.getName() + "   " + " dr id ==>" + dr.getId());
				flg = false;
			}
		}
		
		if(flg)
			return 0;
		
		int id = 0;
		
		while(true)
		{
			try {
				System.out.println("Enter the dr id...");
				id = Integer.parseInt(scanner.nextLine());
				break;
			}
			catch(NumberFormatException e){
				System.out.println("enter valid number");
			}
		}
		
		return id;
	}

	private boolean validMobNum(String num) {
		// TODO Auto-generated method stub
		if(num.length() < 10 || num.length() > 12)
			return false;
		return true;
	}
}

package careplus.features.base;

import java.util.HashMap;
import java.util.Scanner;

import careplus.features.receptionist.ReceptionistMain;
import careplus.repository.db.HospitalRepository;
import careplus.repository.dto.Doctor;

public class DoctorManage 
{

	private static int doctorId = 1;
	private final Scanner scanner = new Scanner(System.in);
	private final HospitalRepository repo = HospitalRepository.getInstance();
	
	public void showMainMenu()
	{
		manageDoctors();
	}
	
	private void manageDoctors() {
		// TODO Auto-generated method stub
		while(true)
		{
			System.out.println("\n *** manage doctors ***");
			System.out.println("1.  add doctors");
			System.out.println("2.  view doctors");
			System.out.println("3.  delete doctors");
			System.out.println("4. back to main menu");
			
			try
			{
				int choice = Integer.parseInt(scanner.nextLine());
				
				switch(choice)
				{
				case 1:
					addDoctors();
					break;
				case 2 :
					viewDoctors();
					break;
				case 3:
					deleteDoctors();
					break;
				case 4 :
					new BaseView().showMainMenu();
					break;
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

	private void deleteDoctors() {
		// TODO Auto-generated method stub
		
	}

	private void viewDoctors() {
		// TODO Auto-generated method stub

		System.out.println("\n *** doctors lists *** \n");
		HashMap<Integer, Doctor> doctors = repo.getAllDoctors();
		
		for(Doctor dr : doctors.values())
		{
			System.out.println(dr);
		}
	}

	private void addDoctors() {
		// TODO Auto-generated method stub
		String name;
		String mobNum;
		String specialist;
		int startTime = 0;
		int endTime = 0;
		int appoinmentCount;		

		System.out.println("\n *** add new doctors *** \n");
		do
		{
			System.out.println("Enter name...");
			name = scanner.nextLine();
		}
		while(!validName(name));
		
		do
		{
			System.out.println("Enter mobile number...");
			mobNum = scanner.nextLine();
		}
		while(!validMobNum(mobNum.trim()));
		
		do
		{
			System.out.println("Enter specialist...");
			specialist = scanner.nextLine();
		}
		while(!validName(specialist));
		
		do
		{
			try {

				System.out.println("Enter start time 24hr format...");
				startTime = Integer.parseInt(scanner.nextLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println("enter valid numbers...!");
			}
		}
		while(!validTime(startTime));
		
		do
		{
			try {

				System.out.println("Enter end time 24hr format...");
				endTime = Integer.parseInt(scanner.nextLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println("enter valid numbers...!");
			}
		}
		while(!validTime(endTime));
		
		do
		{
			try {
				
				System.out.println("Enter the availability of appointments...");
				appoinmentCount = Integer.parseInt(scanner.nextLine());
				break;
			}
			catch(NumberFormatException e)
			{
				System.out.println("enter valid numbers...!");
			}
		}
		while(true);
		
		repo.setDoctors(doctorId, new Doctor(doctorId, name, mobNum, specialist, startTime, endTime, appoinmentCount));
		System.out.println("Doctor added successfully...!");
		System.out.println("doctor name ==>" + name);
		System.out.println("doctor id ==>" + doctorId++);
		
	}

	private boolean validTime(int time) {
		// TODO Auto-generated method stub
		if(time < 0 || time > 24)
		return false;
		return true;
	}

	private boolean validMobNum(String num) {
		// TODO Auto-generated method stub
		if(num.length() < 10 || num.length() > 12)
			return false;
		return true;
	}

	private boolean validDoctorId(int id) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, Doctor> doctors = repo.getAllDoctors();
		if(doctors.containsKey(id))
			return true;
		return false;
	}

	private boolean validName(String name) {
		// TODO Auto-generated method stub
		for(char c : name.toCharArray())
			if(!((c >= 'a' && c <= 'z' ) || (c >= 'A' && c <= 'Z')))
				return false;
		
		return true;
	}
	
}

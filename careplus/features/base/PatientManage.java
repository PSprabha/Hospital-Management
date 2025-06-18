package careplus.features.base;

import java.util.Scanner;

import careplus.features.receptionist.ReceptionistMain;
import careplus.repository.db.HospitalRepository;
import careplus.repository.dto.Patient;

public class PatientManage {

	private static int patientId = 1;
	private final Scanner scanner = new Scanner(System.in);
	private final HospitalRepository repo = HospitalRepository.getInstance();
	
	public void showMainMenu()
	{
		while(true)
		{
			System.out.println("\n *** patient management ***");
			System.out.println("1.   Add patient");
			System.out.println("2.   search patient");
			System.out.println("3.   Back to main menu");
			
			try
			{
				int choice = Integer.parseInt(scanner.nextLine());
				
				switch(choice)
				{
				case 1:
					addPatient();
					break;
				case 2 :
					searchPatient();
					break;
				case 3 :
					new BaseView().showMainMenu();
					return;
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

	public void searchPatient() {
		// TODO Auto-generated method stub

		System.out.println("\n *** search patients by name *** \n");
		
		String name;
		do
		{
			System.out.println("Enter name...");
			name = scanner.nextLine();
		}
		while(!validName(name));
		
		for(Patient p : repo.getAllPatients().values())
		{
			if(p.getName().toLowerCase().contains(name.trim().toLowerCase()))
			{
				System.out.println("name ==> " + p.getName());
				System.out.println("id ==>" + p.getId());
				System.out.println();
			}
		}
		
	}

	public void addPatient() {
		// TODO Auto-generated method stub

		System.out.println("\n *** add patients *** \n");
		String name;
		String mobNum;
		int age;
		String location;	

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
		while(!(validMobNum(mobNum.trim()) && !repo.getAllPatients().containsKey(mobNum)));
		
		
		while(true) {
			System.out.println("Enter the age...!");
			try {
				age = Integer.parseInt(scanner.nextLine());
				
				if(age < 0)
					continue;
				
				break;
			}
			catch(NumberFormatException e){
				System.out.println("Enter valid age");
			}
		}
		
		do
		{
			System.out.println("Enter location ...");
			location = scanner.nextLine();
		}
		while(!validName(location));
		
		repo.setPatient(mobNum, new Patient(patientId, name, mobNum, age, location));
		System.out.println("Patient added successfuly...!");
		System.out.println("Name ==> " + name);
		System.out.println("id ==> " + patientId);
		
	}
	
	
	private boolean validMobNum(String num) {
		// TODO Auto-generated method stub
		if(num.length() < 10 || num.length() > 12)
			return false;
		return true;
	}
	

	private boolean validName(String name) {
		// TODO Auto-generated method stub
		for(char c : name.toCharArray())
			if(!((c >= 'a' && c <= 'z' ) || (c >= 'A' && c <= 'Z')))
				return false;
		
		return true;
	}
}

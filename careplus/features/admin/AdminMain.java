package careplus.features.admin;

import java.util.HashMap;

import java.util.Scanner;

import careplus.Main;
import careplus.features.base.DoctorManage;
import careplus.features.registration.Registration;
import careplus.repository.db.HospitalRepository;
import careplus.repository.dto.Admin;
import careplus.repository.dto.Receptionist;


public class AdminMain {

	private static int receptionistId = 1;
	private final Scanner scanner = new Scanner(System.in);
	private final HospitalRepository repo = HospitalRepository.getInstance();
	HashMap<Integer, Admin> admins = repo.getAllAdmin();
	
	public void showMainMenu() {
		// TODO Auto-generated method stub
		
		if(repo.getAllReceptionists().isEmpty())
		{
			System.out.println("\n no receptionist are there so...Register the receptionist");
			addReceptionist();
		}
		
		while(true)
		{
			System.out.println("\n *** admin menu ***");
			System.out.println("1.  manage doctors");
			System.out.println("2.  manage receptionist");
			System.out.println("3.  Login");
			System.out.println("4.  logout");
			System.out.println("5.  exit");
			
			try
			{
				int choice = Integer.parseInt(scanner.nextLine());
				
				switch(choice)
				{
				case 1:
					new DoctorManage().showMainMenu();
					break;
				case 2 :
					manageReceptionist();
					break;
				case 3:
					new Registration().login();
					break;
				case 4:
					new Main().main(new String[] {"care plus system..."});
					break;
				case 5:
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

	private void manageReceptionist() {
		// TODO Auto-generated method stub
		while(true)
		{
			System.out.println("\n *** manage receptionist ***");
			System.out.println("1.  add receptionist");
			System.out.println("2.  delete receptionist");
			System.out.println("3. back to main menu");
			
			try
			{
				int choice = Integer.parseInt(scanner.nextLine());
				
				switch(choice)
				{
				case 1:
					addReceptionist();
					break;
				case 2:
					deleteReceptionist();
					break;
				case 3 :
					showMainMenu();
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

	private void deleteReceptionist() {
		// TODO Auto-generated method stub
		int id = 0;
		System.out.println("\n *** delete receptionist *** \n");
		

		HashMap<Integer, Receptionist> receptionists = repo.getAllReceptionists();
		
		if(receptionists.isEmpty())
		{
			System.out.println("No receptionist are there...");
			return;
		}
		
		while(true)
		{
			System.out.println("Enter the receptionist id ==> ");
			try
			{
				id = Integer.parseInt(scanner.nextLine());
				break;
			}
			catch(NumberFormatException e)
			{
				System.out.println("Enter valid number!!");
			}
		}
		
		if(!receptionists.containsKey(id))
		{
			System.out.println("\n No receptionist are found...");
			return;
		}
		receptionists.remove(id);
		System.out.println("Receptionist remove successfully..!");
	}

	private void addReceptionist() {
		// TODO Auto-generated method stub
		
		String name;
		String password;

		System.out.println("\n *** add receptionist *** \n");
		do
		{
			System.out.println("Enter name...");
			name = scanner.nextLine();
		}
		while(!validName(name));
		
		do
		{
			System.out.println("Enter password...");
			password = scanner.nextLine();
		}
		while(!validPassword(password.trim()));
		
		repo.setReceptionists(receptionistId, new Receptionist(receptionistId,name,password));
		
		System.out.println("receptionist add successfully...!");
		System.out.println("name ==> " + name);
		System.out.println("id ==> " + (receptionistId++));
		
		
	}

//	private void addAdmin() {
//		// TODO Auto-generated method stub
//		
//		String name;
//		String password;
//		
//		do
//		{
//			System.out.println("Enter name...");
//			name = scanner.nextLine();
//		}
//		while(!validName(name));
//		
//		do
//		{
//			System.out.println("Enter password...");
//			password = scanner.nextLine();
//		}
//		while(!validPassword(password.trim()));
//		
//		repo.setAdmin(Registration.adminId, new Admin(adminId,name,password));
//		
//		System.out.println("Admin registration complete...!");
//		System.out.println("name ==> " + name);
//		System.out.println("id ==> " + (adminId++));
//	}
//	


	private boolean validPassword(String password) {
		// TODO Auto-generated method stub
		if(password.length() < 6)
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

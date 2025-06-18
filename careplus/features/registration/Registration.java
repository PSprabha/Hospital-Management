package careplus.features.registration;

import java.util.HashMap;
import java.util.Scanner;

import careplus.features.admin.AdminMain;
import careplus.features.receptionist.ReceptionistMain;
import careplus.repository.db.HospitalRepository;
import careplus.repository.dto.Admin;
import careplus.repository.dto.Receptionist;

public class Registration {

	private static int adminId = 1;
	
	private final Scanner scanner = new Scanner(System.in);
	HospitalRepository repo = HospitalRepository.getInstance();

	public void login() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			System.out.println("\n *** login ***");
			System.out.println("1.  Admin login");
			System.out.println("2.  Receptionist login");
			System.out.println("3.  exit");
			
			try
			{
				int choice = Integer.parseInt(scanner.nextLine());
				
				switch(choice)
				{
				case 1:
					adminLogin();
					break;
				case 2 :
					receptionistLogin();
					break;
				case 3:
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

	private void receptionistLogin() {
		// TODO Auto-generated method stub
		
		if(repo.getAllAdmin().isEmpty())
		{
			System.out.println("\n Please register the admin");
			adminRegistrtion();
		}
		
		if(repo.getAllReceptionists().isEmpty())
		{
			System.out.println("Plase register the receptionist 1st");
			System.out.println("Or login by admin");
			adminLogin();
		}
		
		System.out.println("\n *** receptionist login ***");
		int id = 0;
		String password;
		
		do {
			try {

				System.out.println("enter receptionist id...!");
				id = Integer.parseInt(scanner.nextLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println("enter valid numbers...!");
			}
		}while(!validReceptionistId(id));
		
		Receptionist crnt = repo.getReceptionists(id);
		
		do
		{
			System.out.println("Enter password... length should greater than 5");
			password = scanner.nextLine();
		}
		while(!validPassword(password.trim()) && !crnt.getPassword().equals(password));
		
		System.out.println("Receptionist login successfull..!");
		
		new ReceptionistMain().showMainMenu();
	}
	
	

	private boolean validReceptionistId(int id) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, Receptionist> recep = repo.getAllReceptionists();
		
		return recep.containsKey(id);
	}
	
	
	

	private void adminLogin() {
		// TODO Auto-generated method stub
		
		if(repo.getAllAdmin().isEmpty())
		{
			System.out.println("\n Plaese register the admin...");
			adminRegistrtion();
		}

		System.out.println("\n *** admin login ***");
		int id = 0;
		String password;
		
		do {
			try {

				System.out.println("enter admin's id...!");
				id = Integer.parseInt(scanner.nextLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println("enter valid numbers...!");
			}
		}while(!validAdminId(id));
		
		Admin crnt = repo.getAdmin(id);
		
		do
		{
			System.out.println("Enter password... length should greater than 5");
			password = scanner.nextLine();
		}
		while(!validPassword(password.trim()) && !crnt.getPassword().equals(password));
		
		System.out.println("Admin login successfull..!");
		
		new AdminMain().showMainMenu();
		
	}
	
	
	

	private boolean validAdminId(int id) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, Admin> admins = repo.getAllAdmin();
		
		if(!admins.containsKey(id))
			return false;
		
		return true;
	}

	private void adminRegistrtion() {
		// TODO Auto-generated method stub
		
		String name;
		String password;

		System.out.println("\n *** admin registration ***");
		
		do
		{
			System.out.println("Enter name...");
			name = scanner.nextLine();
		}
		while(!validName(name));
		
		do
		{
			System.out.println("Enter password... length should greater than 5");
			password = scanner.nextLine();
		}
		while(!validPassword(password.trim()));
		
		repo.setAdmin(adminId, new Admin(adminId,name,password));
		
		System.out.println("Admin registration complete...!");
		System.out.println("name ==> " + name);
		System.out.println("id ==> " + (adminId++));
		
	}

	private boolean validPassword(String password) {
		// TODO Auto-generated method stub
		if(password.length() < 6)
			return false;
		return true;
	}

	private boolean validName(String name) {
		// TODO Auto-generated method stub
		if(name.length() < 3)
		{
			System.out.println("Enter valid name");
			return false;
		}
		for(char c : name.toCharArray())
			if(!((c >= 'a' && c <= 'z' ) || (c >= 'A' && c <= 'Z')))
				return false;
		
		return true;
	}

}

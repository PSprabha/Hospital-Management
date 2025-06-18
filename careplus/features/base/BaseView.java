package careplus.features.base;

import java.util.Scanner;

import careplus.Main;

public class BaseView {
	
	private final Scanner scanner = new Scanner(System.in);
	
	public void showMainMenu()
	{
		while(true)
		{
			System.out.println("\n *** Main Menu ***");
			System.out.println("1.  manage doctors");
			System.out.println("2.  manage patient");
			System.out.println("3.  manage appointment");
			System.out.println("4.  logout");
			
			try
			{
				int choice = Integer.parseInt(scanner.nextLine());
				
				switch(choice)
				{
				case 1:
					new DoctorManage().showMainMenu();
					break;
				case 2:
					new PatientManage().showMainMenu();
					break;
				case 3:
					new AppointmentManage().showMainMenu();
					break;
				case 4:
					new Main().main(new String[] {"care plus system..."});
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
}

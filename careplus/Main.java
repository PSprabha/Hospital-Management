package careplus;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("\n *** care plus ***");
			System.out.println("1.   Login");
			System.out.println("2.   Exit");
			
			try
			{
				int choice = Integer.parseInt(scanner.nextLine());
				
				switch(choice)
				{
				case 1:
					new careplus.features.registration.Registration().login();
					break;
				case 2:
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

}

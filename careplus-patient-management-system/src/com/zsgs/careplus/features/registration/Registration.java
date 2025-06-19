package com.zsgs.careplus.features.registration;

import java.util.Scanner;

import com.zsgs.careplus.features.admin.AdminView;
import com.zsgs.careplus.features.receptionist.ReceptionistView;
import com.zsgs.careplus.repository.db.AdminDao;
import com.zsgs.careplus.repository.db.ReceptionistDao;

public class Registration {
    public void login() {
    	
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nLogin as:");
            System.out.println("1. Admin");
            System.out.println("2. Receptionist");
            System.out.println("3. Back to Main Menu");
            
            int choice = -1;
            while (true) {
                try {
                    System.out.print("Enter your choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number!");
                }
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter admin username: ");
                    String adminUser = scanner.nextLine();
                    System.out.print("Enter admin password: ");
                    String adminPass = scanner.nextLine();
                    if (AdminDao.login(adminUser, adminPass)) {
                        new AdminView().showMenu(adminUser);
                    } else {
                        System.out.println("Invalid admin credentials!");
                    }
                    break;
                case 2:
                    System.out.print("Enter receptionist username: ");
                    String recUser = scanner.nextLine();
                    System.out.print("Enter receptionist password: ");
                    String recPass = scanner.nextLine();
                    if (ReceptionistDao.login(recUser, recPass)) {
                        new ReceptionistView().showMenu(recUser);
                    } else {
                        System.out.println("Invalid receptionist credentials!");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Please enter valid choice...!");
            }
        }
    }
} 
package com.zsgs.careplus;

import java.util.Scanner;

import com.zsgs.careplus.features.registration.Registration;
import com.zsgs.careplus.repository.db.AdminDao;
import com.zsgs.careplus.repository.db.ReceptionistDao;
import com.zsgs.careplus.repository.dto.Admin;
import com.zsgs.careplus.repository.dto.Receptionist;

public class Main {
    public static void main(String[] args) {
    	
        // Initialize database with default accounts if they don't exist
        initializeDefaultAccounts();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n *** care plus ***");
            System.out.println("1.   Login");
            System.out.println("2.   Exit");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        new Registration().login();
                        break;
                    case 2:
                        System.exit(0);
                    default:
                        System.out.println("Please enter valid choice...!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter the valid number...!");
            }
        }
    }
    
    private static void initializeDefaultAccounts() {
        try {
            // Check if admin exists, if not create default admin
            if (!AdminDao.login("admin", "admin123")) {
                Admin defaultAdmin = new Admin();
                defaultAdmin.setUsername("admin");
                defaultAdmin.setPassword("admin123");
                if (AdminDao.addAdmin(defaultAdmin)) {
                    System.out.println("Default admin account created successfully! \n ");
                	System.out.println("admin's user_name is ==> " + " admin");
                	System.out.println("admin's user_password is ==> " + " admin123 \n");
                }
            }
            
            // Check if receptionist exists, if not create default receptionist
            if (!ReceptionistDao.login("reception", "reception123")) {
                Receptionist defaultReceptionist = new Receptionist();
                defaultReceptionist.setUsername("reception");
                defaultReceptionist.setPassword("reception123");
                if (ReceptionistDao.addReceptionist(defaultReceptionist)) {
                    System.out.println("Default receptionist account created successfully! \n");
                	System.out.println("receptionist user_name is ==> " + " reception");
                	System.out.println("receptionist user_password is ==> " + " reception123 /n");
                }
            }
        } catch (Exception e) {
            System.out.println("Error initializing default accounts: " + e.getMessage());
        }
    }
} 
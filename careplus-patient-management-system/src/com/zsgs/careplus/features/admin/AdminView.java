package com.zsgs.careplus.features.admin;

import java.util.Scanner;

import com.zsgs.careplus.features.admin.AdminModel;

public class AdminView {
    private AdminModel adminModel;
    private Scanner scanner;

    public AdminView() {
        this.adminModel = new AdminModel();
        this.scanner = new Scanner(System.in);
    }

    public void showMenu(String username) {
        System.out.println("\nWelcome, " + username + "!");
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Add Doctor");
            System.out.println("2. Manage Receptionists");
            System.out.println("3. View All Appointments");
            System.out.println("4. Logout");

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
                    addDoctor();
                    break;
                case 2:
                    manageReceptionists();
                    break;
                case 3:
                    viewAllAppointments();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Please enter valid choice...!");
            }
        }
    }

    private void addDoctor() {
        System.out.println("\n=== Add Doctor ===");
        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter mobile number: ");
        String mobile = scanner.nextLine();
        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter available slots (e.g., morning,afternoon,night): ");
        String availableSlots = scanner.nextLine();

        if (adminModel.addDoctor(name, mobile, specialization, availableSlots)) {
            System.out.println("Doctor added successfully!");
        } else {
            System.out.println("Failed to add doctor!");
        }
    }

    private void manageReceptionists() {
        System.out.println("\n=== Manage Receptionists ===");
        System.out.println("1. Add Receptionist");
        System.out.println("2. View All Receptionists");
        System.out.println("3. Back to Admin Menu");

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
                addReceptionist();
                break;
            case 2:
                viewAllReceptionists();
                break;
            case 3:
                return;
            default:
                System.out.println("Please enter valid choice...!");
        }
    }

    private void addReceptionist() {
        System.out.println("\n=== Add Receptionist ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (adminModel.addReceptionist(username, password)) {
            System.out.println("Receptionist added successfully!");
        } else {
            System.out.println("Failed to add receptionist!");
        }
    }

    private void viewAllReceptionists() {
        System.out.println("\n=== All Receptionists ===");
        adminModel.displayAllReceptionists();
    }

    private void viewAllAppointments() {
        System.out.println("\n=== All Appointments ===");
        adminModel.displayAllAppointments();
    }
}

package com.zsgs.careplus.features.receptionist;

import java.util.Scanner;

public class ReceptionistView {
    private ReceptionistModel receptionistModel;
    private Scanner scanner;

    public ReceptionistView() {
        this.receptionistModel = new ReceptionistModel();
        this.scanner = new Scanner(System.in);
    }

    public void showMenu(String username) {
        System.out.println("\nWelcome, " + username + "!");
        while (true) {
            System.out.println("\n=== Receptionist Menu ===");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Search Patients");
            System.out.println("6. Logout");

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
                    addPatient();
                    break;
                case 3:
                    bookAppointment();
                    break;
                case 4:
                    viewAppointments();
                    break;
                case 5:
                    searchPatients();
                    break;
                case 6:
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
        System.out.print("Enter available slots (e.g., morning,afternoon): ");
        String availableSlots = scanner.nextLine();

        if (receptionistModel.addDoctor(name, mobile, specialization, availableSlots)) {
            System.out.println("Doctor added successfully!");
        } else {
            System.out.println("Failed to add doctor!");
        }
    }

    private void addPatient() {
        System.out.println("\n=== Add Patient ===");
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        
        int age = -1;
        while (true) {
            try {
                System.out.print("Enter age: ");
                age = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
        
        System.out.print("Enter contact number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter other details (optional): ");
        String otherDetails = scanner.nextLine();

        if (receptionistModel.addPatient(name, age, contact, otherDetails)) {
            System.out.println("Patient added successfully!");
        } else {
            System.out.println("Failed to add patient!");
        }
    }

    private void bookAppointment() {
        System.out.println("\n=== Book Appointment ===");
        
        receptionistModel.displayAllPatients();
        System.out.print("Enter patient ID: ");
        int patientId = -1;
        while (true) {
            try {
                patientId = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }

        receptionistModel.displayAllDoctors();
        System.out.print("Enter doctor ID: ");
        int doctorId = -1;
        while (true) {
            try {
                doctorId = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }

        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter appointment time (HH:MM): ");
        String time = scanner.nextLine();

        if (receptionistModel.bookAppointment(patientId, doctorId, date, time)) {
            System.out.println("Appointment booked successfully!");
        } else {
            System.out.println("Failed to book appointment!");
        }
    }

    private void viewAppointments() {
        System.out.println("\n=== View Appointments ===");
        System.out.println("1. View all appointments");
        System.out.println("2. View appointments by patient");
        System.out.println("3. View appointments by doctor");
        System.out.println("4. Back to Receptionist Menu");

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
                receptionistModel.displayAllAppointments();
                break;
            case 2:
                System.out.print("Enter patient ID: ");
                int patientId = -1;
                while (true) {
                    try {
                        patientId = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number!");
                    }
                }
                receptionistModel.displayAppointmentsByPatient(patientId);
                break;
            case 3:
                System.out.print("Enter doctor ID: ");
                int doctorId = -1;
                while (true) {
                    try {
                        doctorId = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number!");
                    }
                }
                receptionistModel.displayAppointmentsByDoctor(doctorId);
                break;
            case 4:
                return;
            default:
                System.out.println("Please enter valid choice...!");
        }
    }

    private void searchPatients() {
        System.out.println("\n=== Search Patients ===");
        System.out.print("Enter patient name to search: ");
        String name = scanner.nextLine();
        receptionistModel.searchPatientsByName(name);
    }
} 
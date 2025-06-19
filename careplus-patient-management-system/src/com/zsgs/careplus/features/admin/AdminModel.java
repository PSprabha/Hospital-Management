package com.zsgs.careplus.features.admin;

import java.util.List;

import com.zsgs.careplus.repository.db.AppointmentDao;
import com.zsgs.careplus.repository.db.DoctorDao;
import com.zsgs.careplus.repository.db.ReceptionistDao;
import com.zsgs.careplus.repository.dto.Appointment;
import com.zsgs.careplus.repository.dto.Doctor;
import com.zsgs.careplus.repository.dto.Receptionist;

public class AdminModel {
    public boolean addDoctor(String name, String mobile, String specialization, String availableSlots) {
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setMobile(mobile);
        doctor.setSpecialization(specialization);
        doctor.setAvailableSlots(availableSlots);
        return DoctorDao.addDoctor(doctor);
    }

    public boolean addReceptionist(String username, String password) {
        Receptionist receptionist = new Receptionist();
        receptionist.setUsername(username);
        receptionist.setPassword(password);
        return ReceptionistDao.addReceptionist(receptionist);
    }

    public void displayAllReceptionists() {
        List<Receptionist> receptionists = ReceptionistDao.getAllReceptionists();
        if (receptionists.isEmpty()) {
            System.out.println("No receptionists found.");
            return;
        }
        System.out.println("ID\tUsername");
        System.out.println("--\t--------");
        for (Receptionist receptionist : receptionists) {
            System.out.println(receptionist.getId() + "\t" + receptionist.getUsername());
        }
    }

    public void displayAllAppointments() {
        List<Appointment> appointments = AppointmentDao.getAllAppointments();
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }
        System.out.println("ID\tPatient ID\tDoctor ID\tDate\t\tTime");
        System.out.println("--\t----------\t---------\t----\t\t----");
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getId() + "\t" + 
                             appointment.getPatientId() + "\t\t" + 
                             appointment.getDoctorId() + "\t\t" + 
                             appointment.getAppointmentDate() + "\t" + 
                             appointment.getAppointmentTime());
        }
    }
} 
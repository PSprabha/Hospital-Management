package com.zsgs.careplus.features.receptionist;

import java.util.List;

import com.zsgs.careplus.repository.db.AppointmentDao;
import com.zsgs.careplus.repository.db.DoctorDao;
import com.zsgs.careplus.repository.db.PatientDao;
import com.zsgs.careplus.repository.dto.Appointment;
import com.zsgs.careplus.repository.dto.Doctor;
import com.zsgs.careplus.repository.dto.Patient;

public class ReceptionistModel {
    public boolean addDoctor(String name, String mobile, String specialization, String availableSlots) {
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setMobile(mobile);
        doctor.setSpecialization(specialization);
        doctor.setAvailableSlots(availableSlots);
        return DoctorDao.addDoctor(doctor);
    }

    public boolean addPatient(String name, int age, String contact, String otherDetails) {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setAge(age);
        patient.setContact(contact);
        patient.setOtherDetails(otherDetails);
        return PatientDao.addPatient(patient);
    }

    public boolean bookAppointment(int patientId, int doctorId, String date, String time) {
        if (!AppointmentDao.isSlotAvailable(doctorId, date, time)) {
            System.out.println("This time slot is not available for the selected doctor.");
            return false;
        }

        Appointment appointment = new Appointment();
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);
        appointment.setAppointmentTime(time);
        return AppointmentDao.addAppointment(appointment);
    }

    public void displayAllPatients() {
        List<Patient> patients = PatientDao.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        System.out.println("ID\tName\t\tAge\tContact");
        System.out.println("--\t----\t\t---\t-------");
        for (Patient patient : patients) {
            System.out.println(patient.getId() + "\t" + 
                             patient.getName() + "\t\t" + 
                             patient.getAge() + "\t" + 
                             patient.getContact());
        }
    }

    public void displayAllDoctors() {
        List<Doctor> doctors = DoctorDao.getAllDoctors();
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }
        System.out.println("ID\tName\t\tSpecialization\t\tAvailable Slots");
        System.out.println("--\t----\t\t---------------\t\t---------------");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getId() + "\t" + 
                             doctor.getName() + "\t\t" + 
                             doctor.getSpecialization() + "\t\t" + 
                             doctor.getAvailableSlots());
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

    public void displayAppointmentsByPatient(int patientId) {
        List<Appointment> appointments = AppointmentDao.getAppointmentsByPatientId(patientId);
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for this patient.");
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

    public void displayAppointmentsByDoctor(int doctorId) {
        List<Appointment> appointments = AppointmentDao.getAppointmentsByDoctorId(doctorId);
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for this doctor.");
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

    public void searchPatientsByName(String name) {
        List<Patient> patients = PatientDao.findPatientsByName(name);
        if (patients.isEmpty()) {
            System.out.println("No patients found with name containing: " + name);
            return;
        }
        System.out.println("ID\tName\t\tAge\tContact");
        System.out.println("--\t----\t\t---\t-------");
        for (Patient patient : patients) {
            System.out.println(patient.getId() + "\t" + 
                             patient.getName() + "\t\t" + 
                             patient.getAge() + "\t" + 
                             patient.getContact());
        }
    }
} 
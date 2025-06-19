package com.zsgs.careplus.repository.db;

import java.sql.*;
import java.util.*;

import com.zsgs.careplus.repository.dto.Patient;

public class PatientDao {
    public static boolean addPatient(Patient patient) {
        String sql = "INSERT INTO patients (name, age, contact, other_details) VALUES (?, ?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setString(3, patient.getContact());
            stmt.setString(4, patient.getOtherDetails());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error adding patient: " + e.getMessage());
            return false;
        }
    }

    public static List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setAge(rs.getInt("age"));
                patient.setContact(rs.getString("contact"));
                patient.setOtherDetails(rs.getString("other_details"));
                patients.add(patient);
            }
        } catch (Exception e) {
            System.out.println("Error fetching patients: " + e.getMessage());
        }
        return patients;
    }

    public static Patient findPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Patient patient = new Patient();
                    patient.setId(rs.getInt("id"));
                    patient.setName(rs.getString("name"));
                    patient.setAge(rs.getInt("age"));
                    patient.setContact(rs.getString("contact"));
                    patient.setOtherDetails(rs.getString("other_details"));
                    return patient;
                }
            }
        } catch (Exception e) {
            System.out.println("Error finding patient: " + e.getMessage());
        }
        return null;
    }

    public static List<Patient> findPatientsByName(String name) {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients WHERE name LIKE ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Patient patient = new Patient();
                    patient.setId(rs.getInt("id"));
                    patient.setName(rs.getString("name"));
                    patient.setAge(rs.getInt("age"));
                    patient.setContact(rs.getString("contact"));
                    patient.setOtherDetails(rs.getString("other_details"));
                    patients.add(patient);
                }
            }
        } catch (Exception e) {
            System.out.println("Error searching patients: " + e.getMessage());
        }
        return patients;
    }
} 
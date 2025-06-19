package com.zsgs.careplus.repository.db;

import java.sql.*;
import java.util.*;

import com.zsgs.careplus.repository.dto.Doctor;

public class DoctorDao {
    public static boolean addDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors (name, mobile, specialization, available_slots) VALUES (?, ?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getMobile());
            stmt.setString(3, doctor.getSpecialization());
            stmt.setString(4, doctor.getAvailableSlots());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error adding doctor: " + e.getMessage());
            return false;
        }
    }

    public static List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("id"));
                doctor.setName(rs.getString("name"));
                doctor.setMobile(rs.getString("mobile"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setAvailableSlots(rs.getString("available_slots"));
                doctors.add(doctor);
            }
        } catch (Exception e) {
            System.out.println("Error fetching doctors: " + e.getMessage());
        }
        return doctors;
    }

    public static Doctor findDoctorById(int id) {
        String sql = "SELECT * FROM doctors WHERE id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Doctor doctor = new Doctor();
                    doctor.setId(rs.getInt("id"));
                    doctor.setName(rs.getString("name"));
                    doctor.setMobile(rs.getString("mobile"));
                    doctor.setSpecialization(rs.getString("specialization"));
                    doctor.setAvailableSlots(rs.getString("available_slots"));
                    return doctor;
                }
            }
        } catch (Exception e) {
            System.out.println("Error finding doctor: " + e.getMessage());
        }
        return null;
    }
} 
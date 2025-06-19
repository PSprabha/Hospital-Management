package com.zsgs.careplus.repository.db;

import java.sql.*;
import java.util.*;

import com.zsgs.careplus.repository.dto.Appointment;

public class AppointmentDao 
{
    public static boolean addAppointment(Appointment appointment) 
    {
        String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, appointment_time) VALUES (?, ?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, appointment.getPatientId());
            stmt.setInt(2, appointment.getDoctorId());
            stmt.setString(3, appointment.getAppointmentDate());
            stmt.setString(4, appointment.getAppointmentTime());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error adding appointment: " + e.getMessage());
            return false;
        }
    }

    public static List<Appointment> getAppointmentsByPatientId(int patientId) 
    {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE patient_id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, patientId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Appointment appointment = new Appointment();
                    appointment.setId(rs.getInt("id"));
                    appointment.setPatientId(rs.getInt("patient_id"));
                    appointment.setDoctorId(rs.getInt("doctor_id"));
                    appointment.setAppointmentDate(rs.getString("appointment_date"));
                    appointment.setAppointmentTime(rs.getString("appointment_time"));
                    appointments.add(appointment);
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching patient appointments: " + e.getMessage());
        }
        return appointments;
    }

    public static List<Appointment> getAppointmentsByDoctorId(int doctorId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE doctor_id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, doctorId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Appointment appointment = new Appointment();
                    appointment.setId(rs.getInt("id"));
                    appointment.setPatientId(rs.getInt("patient_id"));
                    appointment.setDoctorId(rs.getInt("doctor_id"));
                    appointment.setAppointmentDate(rs.getString("appointment_date"));
                    appointment.setAppointmentTime(rs.getString("appointment_time"));
                    appointments.add(appointment);
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching doctor appointments: " + e.getMessage());
        }
        return appointments;
    }

    public static List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setId(rs.getInt("id"));
                appointment.setPatientId(rs.getInt("patient_id"));
                appointment.setDoctorId(rs.getInt("doctor_id"));
                appointment.setAppointmentDate(rs.getString("appointment_date"));
                appointment.setAppointmentTime(rs.getString("appointment_time"));
                appointments.add(appointment);
            }
        } catch (Exception e) {
            System.out.println("Error fetching all appointments: " + e.getMessage());
        }
        return appointments;
    }

    public static boolean isSlotAvailable(int doctorId, String date, String time) {
        String sql = "SELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND appointment_date = ? AND appointment_time = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, doctorId);
            stmt.setString(2, date);
            stmt.setString(3, time);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) == 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Error checking slot availability: " + e.getMessage());
        }
        return false;
    }
} 
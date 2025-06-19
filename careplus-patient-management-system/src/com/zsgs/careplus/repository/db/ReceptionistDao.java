package com.zsgs.careplus.repository.db;

import java.sql.*;
import java.util.*;

import com.zsgs.careplus.repository.dto.Receptionist;

public class ReceptionistDao {
    public static boolean login(String username, String password) {
        String sql = "SELECT * FROM receptionists WHERE username = ? AND password = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            System.out.println("Error during receptionist login: " + e.getMessage());
            return false;
        }
    }

    public static boolean addReceptionist(Receptionist receptionist) {
        String sql = "INSERT INTO receptionists (username, password) VALUES (?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, receptionist.getUsername());
            stmt.setString(2, receptionist.getPassword());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error adding receptionist: " + e.getMessage());
            return false;
        }
    }

    public static List<Receptionist> getAllReceptionists() {
        List<Receptionist> receptionists = new ArrayList<>();
        String sql = "SELECT * FROM receptionists";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Receptionist receptionist = new Receptionist();
                receptionist.setId(rs.getInt("id"));
                receptionist.setUsername(rs.getString("username"));
                receptionist.setPassword(rs.getString("password"));
                receptionists.add(receptionist);
            }
        } catch (Exception e) {
            System.out.println("Error fetching receptionists: " + e.getMessage());
        }
        return receptionists;
    }
} 
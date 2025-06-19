package com.zsgs.careplus.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {
    public static boolean isValidDate(String dateStr) {
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidTime(String timeStr) {
        try {
            String[] parts = timeStr.split(":");
            if (parts.length != 2) return false;
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
} 
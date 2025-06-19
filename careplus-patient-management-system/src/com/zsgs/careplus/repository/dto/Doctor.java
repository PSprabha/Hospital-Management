package com.zsgs.careplus.repository.dto;

public class Doctor {
    private int id;
    private String name;
    private String mobile;
    private String specialization;
    private String availableSlots;

    public Doctor() {}

    public Doctor(int id, String name, String mobile, String specialization, String availableSlots) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.specialization = specialization;
        this.availableSlots = availableSlots;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getAvailableSlots() { return availableSlots; }
    public void setAvailableSlots(String availableSlots) { this.availableSlots = availableSlots; }
} 
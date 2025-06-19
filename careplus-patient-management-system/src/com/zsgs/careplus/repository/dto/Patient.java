package com.zsgs.careplus.repository.dto;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String contact;
    private String otherDetails;

    public Patient() {}

    public Patient(int id, String name, int age, String contact, String otherDetails) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.otherDetails = otherDetails;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getOtherDetails() { return otherDetails; }
    public void setOtherDetails(String otherDetails) { this.otherDetails = otherDetails; }
} 
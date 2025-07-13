package com.example.demo.model;

public class bookingRequest {
    private int NoOfSeats;
    private String classType;

    public int getNoOfSeats() {
        return NoOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        NoOfSeats = noOfSeats;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}

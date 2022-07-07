package com.SmartParking.Proyect.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class RateType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Rate_Type;
    private String booking_Time;
    private double amount;

    public RateType(){}

    public RateType(int id_Rate_Type, String booking_Time, double amount) {
        this.setId_Rate_Type(id_Rate_Type) ;
        this.booking_Time = booking_Time;
        this.amount = amount;
    }

    public int getId_Rate_Type() {
        return id_Rate_Type;
    }

    public void setId_Rate_Type(int id_Rate_Type) {
        this.id_Rate_Type = id_Rate_Type;
    }

    public String getBooking_Time() {
        return booking_Time;
    }

    public void setBooking_Time(String booking_Time) {
        this.booking_Time = booking_Time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

package com.SmartParking.Proyect.domain;

import javax.persistence.*;

public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Spot;

    private int number;
    private String type;
    private String status;

    @ManyToOne
    @JoinColumn(name = "vehicle_Id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "parking_Lot_Id")
    private Parking_Lot parking_lot;

    public Spot(int id_Spot, int number, String type, String status, Vehicle vehicle, Parking_Lot parking_lot) {
        this.setId_Spot(id_Spot);
        this.number = number;
        this.type = type;
        this.status = status;
        this.vehicle = vehicle;
        this.parking_lot=parking_lot;
    }

    public int getId_Spot() {
        return id_Spot;
    }

    public void setId_Spot(int id_Spot) {
        this.id_Spot = id_Spot;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Parking_Lot getParking_lot() {
        return parking_lot;
    }

    public void setParking_lot(Parking_Lot parking_lot) {
        this.parking_lot = parking_lot;
    }
}

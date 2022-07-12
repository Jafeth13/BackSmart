package com.SmartParking.Proyect.domain;

import javax.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Vehicle;
    private String license_Plate;
    private String color;
    private int weight;
    private String brand;
    @ManyToOne
    @JoinColumn(name = "type_Id")
    private Vehicle_Type vehicle_Type;

    public Vehicle(int id_Vehicle, String license_Plate, String color, int weight, String brand, Vehicle_Type vehicle_type) {
        this.setId_Vehicle(id_Vehicle);
        this.setLicense_Plate(license_Plate);
        this.setColor(color);
        this.setWeight(weight);
        this.setBrand(brand);
        this.setVehicle_Type(vehicle_type);
    }

    public Vehicle() {
    }


    public int getId_Vehicle() {
        return id_Vehicle;
    }

    public void setId_Vehicle(int id_Vehicle) {
        this.id_Vehicle = id_Vehicle;
    }

    public String getLicense_Plate() {
        return license_Plate;
    }

    public void setLicense_Plate(String license_Plate) {
        this.license_Plate = license_Plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Vehicle_Type getVehicle_Type() {
        return vehicle_Type;
    }

    public void setVehicle_Type(Vehicle_Type vehicle_Type) {
        this.vehicle_Type = vehicle_Type;
    }
}

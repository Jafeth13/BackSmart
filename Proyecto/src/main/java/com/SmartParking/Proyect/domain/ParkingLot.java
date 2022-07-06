package com.SmartParking.Proyect.domain;
import javax.persistence.*;

import javax.persistence.Entity;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Parking_Lot;
    private String name;
    private String capacity;
    private String province;
    private String district;

    public ParkingLot(int id_Parking_Lot, String name, String capacity, String province, String district) {
        this.setId_ParkingLot(id_Parking_Lot) ;
        this.setName(name);
        this.setCapacity(capacity);
        this.setProvince(province);
        this.setDistrict(district);
    }
    public ParkingLot(){
    }

    public int getId_ParkingLot() {
        return id_Parking_Lot;
    }

    public void setId_ParkingLot(int id_Parking_Lot) {
        this.id_Parking_Lot = id_Parking_Lot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}

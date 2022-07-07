package com.SmartParking.Proyect.domain;
import javax.persistence.*;

import javax.persistence.Entity;

@Entity
public class Parking_Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Parking_Lot;
    private String name;
    private int capacity;
    private String province;
    private String city;
    private String district;

    public Parking_Lot(int id_Parking_Lot, String name,int capacity, String province,String city, String district) {
        this.setId_Parking_Lot(id_Parking_Lot) ;
        this.setName(name);
        this.setCapacity(capacity);
        this.setProvince(province);
        this.setCity(city);
        this.setDistrict(district);
    }
    public Parking_Lot(){
    }

    public int getId_Parking_Lot() {
        return id_Parking_Lot;
    }

    public void setId_Parking_Lot(int id_Parking_Lot) {
        this.id_Parking_Lot = id_Parking_Lot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}

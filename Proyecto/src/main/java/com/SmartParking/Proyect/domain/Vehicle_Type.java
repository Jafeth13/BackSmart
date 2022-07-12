package com.SmartParking.Proyect.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle_Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Type;
    private String name;

    public Vehicle_Type(int id_Type, String name) {
        this.id_Type = id_Type;
        this.name = name;
    }

    public Vehicle_Type() {
    }

    public int getId_Type() {
        return id_Type;
    }

    public void setId_Type(int id_Type) {
        this.id_Type = id_Type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.SmartParking.Proyect.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Role;
    private String name;

    public Role(){}

    public Role(int id_Role, String name) {
        this.setId_Role(id_Role) ;
        this.name = name;
    }

    public int getId_Role() {
        return Id_Role;
    }

    public void setId_Role(int id_Role) {
        Id_Role = id_Role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

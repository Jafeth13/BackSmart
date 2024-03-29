package com.SmartParking.Proyect.domain;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Collection;

@Entity
public class User_Smart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_User;

    private String identification;

    private String name;

    private String last_Name;

    private String tel_Number;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_Id")
    private Role role;
    @ManyToMany
    @JoinTable(name = "Vehicle_User", joinColumns = @JoinColumn(name = "User_Id", referencedColumnName = "Id_User"), inverseJoinColumns = @JoinColumn(name = "Vehicle_Id", referencedColumnName = "Id_Vehicle"))
    private Collection<Vehicle> vehicle;

    public User_Smart(int id_User, String identification, String name, String last_Name, String tel_Number, String email, String password, Role role) {
        this.id_User = id_User;
        this.identification = identification;
        this.name = name;
        this.last_Name = last_Name;
        this.tel_Number = tel_Number;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User_Smart(int id_User, String identification, String name, String last_Name, String tel_number, String email, String password, Role role,Collection<Vehicle> vehicle) {
        this.id_User = id_User;
        this.identification = identification;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.vehicle = vehicle;

    }
    public User_Smart() {

    }

    public Collection<Vehicle> getVehicles() {
        return vehicle;
    }
    public void setVehicle(Collection<Vehicle> vehicle){
        this.vehicle=vehicle;
    }
    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getTel_Number() {
        return tel_Number;
    }

    public void setTel_Number(String tel_Number) {
        this.tel_Number = tel_Number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

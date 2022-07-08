package com.SmartParking.Proyect.domain;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class User_Smart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_User;

    private String identification;

    private String name;

    private String last_Name;

    private String tel_number;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_Id")
    private Role role;

    public User_Smart(int id_User, String identification, String name, String last_Name, String tel_number, String email, String password, Role role) {
        this.id_User = id_User;
        this.identification = identification;
        this.name = name;
        this.last_Name = last_Name;
        this.tel_number = tel_number;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User_Smart() {

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

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
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

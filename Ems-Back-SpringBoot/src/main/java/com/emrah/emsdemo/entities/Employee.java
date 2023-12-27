package com.emrah.emsdemo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Increase id automatically
    private int id;
    @Column(name="first_Name")
    private String first_Name;
    @Column(name="last_Name")
    private String last_Name;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;


    public Employee(int id, String first_Name, String last_Name, String email,String password) {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.email = email;
        this.password = password;
    }

    public Employee(int id, String first_Name, String last_Name, String email) {
        this.id = id;
        this.first_Name = first_Name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}

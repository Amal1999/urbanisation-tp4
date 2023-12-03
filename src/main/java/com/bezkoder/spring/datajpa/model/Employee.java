package com.bezkoder.spring.datajpa.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String cin;
    private Date dateOfBirth;
    private String position;
    private int remainingDaysOff;

    public Employee() {}

    public Employee(String firstName, String lastName, String cin, Date dateOfBirth, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.remainingDaysOff = 0; // Initialisez le nombre de jours restants à zéro ou à une valeur par défaut
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getRemainingDaysOff() {
        return remainingDaysOff;
    }

    public void setRemainingDaysOff(int remainingDaysOff) {
        this.remainingDaysOff = remainingDaysOff;
    }
}

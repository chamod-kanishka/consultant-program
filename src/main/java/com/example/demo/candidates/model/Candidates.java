package com.example.demo.candidates.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Candidates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private double age;
    private boolean state;

    // Default constructor
    public Candidates() {
        // Initialize any default values or leave it empty if not needed
    }

    // Parameterized constructor
    public Candidates(Integer id, String name, double age, boolean state) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.state = state;
    }

    // Getters and setters
    // ...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
    
    public boolean getState() {
    	return state;
    }
    
    public void setState(boolean state) {
    	this.state = state;
    }
}

package com.github.rsoi.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int age;
    private int experience;
    private List<Violation> violations;
    private List<Trip> trips;
    private double totalSpent;

    public User() {
    }

    public User(String name, int age, int experience, List<Violation> violations, List<Trip> trips) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.violations = violations;
        this.trips = trips;
        for (Trip trip : trips) {
            this.totalSpent += trip.getCost();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
        for (Trip trip : trips) {
            this.totalSpent += trip.getCost();
        }
    }




    public Double getTotalSpent() {
        return totalSpent;
    }
}
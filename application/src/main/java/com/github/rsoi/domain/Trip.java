package com.github.rsoi.domain;

import java.time.LocalDate;

public class Trip {
    private double cost = 0;
    private LocalDate date = LocalDate.parse("2023-02-16");

    public Trip() {
    }

    public Trip(double cost, LocalDate date) {
        this.cost = cost;
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

package com.assignment.dto;

import java.sql.Timestamp;

public class GroceriesDto {
    private String name;
    private int quantity;
    private int calories;
    private Timestamp purchase_date;
    private Timestamp expiration_date;
    private Timestamp consumption_date;

    public GroceriesDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Timestamp getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Timestamp purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Timestamp getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Timestamp expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Timestamp getConsumption_date() {
        return consumption_date;
    }

    public void setConsumption_date(Timestamp consumption_date) {
        this.consumption_date = consumption_date;
    }
}

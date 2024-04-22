package com.inventory.classes;

import static com.inventory.classes.Inventory.inventory;

public class Item {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private double totalPrice;

    public Item(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = price * quantity;

    }

    /**
     * Getters for the item object
    */
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public int getIndex() {return inventory.indexOf(this);}

    /**
     * Setters for the item object
     */
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
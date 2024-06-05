package edu.depaul.Products;

public class Car implements Product {

    private int id = 1;
    private String name = "car";
    private double price = 15000;


    @Override
    public void create() {
        System.out.println("Creating a car.");
    }

    @Override
    public int getItemId() {
        return this.id;
    }

    @Override
    public String getItemName() {
        return this.name;
    }

    @Override
    public double getItemPrice() {
        return this.price;
    }
}

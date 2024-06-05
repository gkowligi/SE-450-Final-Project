package edu.depaul.Products;

public class Pants implements Product {

    private int id = 6;
    private String name = "pants";
    private double price = 30;


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
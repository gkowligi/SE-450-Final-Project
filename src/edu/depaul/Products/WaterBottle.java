package edu.depaul.Products;

public class WaterBottle implements Product {

    private int id = 4;
    private String name = "water bottle";
    private double price = 1.5;


    @Override
    public void create() {
        System.out.println("Creating a water bottle.");
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
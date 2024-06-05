package edu.depaul.Products;

public class Headphones implements Product {

    private int id = 10;
    private String name = "headphones";
    private double price = 75;


    @Override
    public void create() {
        System.out.println("Creating headphones.");
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
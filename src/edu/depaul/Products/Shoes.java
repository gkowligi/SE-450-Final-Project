package edu.depaul.Products;

public class Shoes implements Product {

    private int id = 7;
    private String name = "shoes";
    private double price = 25;


    @Override
    public void create() {
        System.out.println("Creating shoes.");
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
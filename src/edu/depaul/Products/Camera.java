package edu.depaul.Products;

public class Camera implements Product {

    private int id = 11;
    private String name = "camera";
    private double price = 500;


    @Override
    public void create() {
        System.out.println("Creating a camera.");
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
package edu.depaul.Products;

public class ProductFactory {
    public static Product createProduct(int itemId) {
        switch (itemId) {
            case 1:
                return new Car();
            case 2:
                return new Computer();
            case 3:
                return new Phone();
            case 4:
                return new WaterBottle();
            case 5:
                return new Shirt();
            case 6:
                return new Pants();
            case 7:
                return new Shoes();
            case 8:
                return new Hat();
            case 9:
                return new Backpack();
            case 10:
                return new Headphones();
            case 11:
                return new Camera();
            default:
                return null;
        }
    }
}

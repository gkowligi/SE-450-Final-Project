package edu.depaul;

public class ShoppingCartManager {

    private static ShoppingCartManager instance;
    private ShoppingCartBuilder shoppingCartBuilder;

    private ShoppingCartManager() {
        shoppingCartBuilder = new ShoppingCartBuilder();
    }

    public static ShoppingCartManager getInstance() {
        if (instance == null) {
            instance = new ShoppingCartManager();
        }
        return instance;
    }

    public ShoppingCartBuilder getShoppingCartBuilder() {
        return shoppingCartBuilder;
    }
}

package edu.depaul;

import edu.depaul.Products.Product;
import edu.depaul.Products.ProductFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartBuilderTest {

    @Test
    void addItem() {
        ShoppingCartBuilder shoppingCartBuilderTest = new ShoppingCartBuilder();
        Product Car = ProductFactory.createProduct(1);
        shoppingCartBuilderTest.addItem(Car, 2);
        assert(shoppingCartBuilderTest.getProductList().size() == 2);
    }

    @Test
    void removeItem() {
        ShoppingCartBuilder shoppingCartBuilderTest = new ShoppingCartBuilder();
        Product Car = ProductFactory.createProduct(1);
        Product Computer = ProductFactory.createProduct(2);
        shoppingCartBuilderTest.addItem(Car, 2);
        shoppingCartBuilderTest.addItem(Computer, 2);

        shoppingCartBuilderTest.removeItem(2 );
        assert(shoppingCartBuilderTest.getProductList().size() == 2);
    }

    @Test
    void clearCart() {
        ShoppingCartBuilder shoppingCartBuilderTest = new ShoppingCartBuilder();
        Product Car = ProductFactory.createProduct(1);
        shoppingCartBuilderTest.addItem(Car, 2);

        shoppingCartBuilderTest.clearCart();
        assert(shoppingCartBuilderTest.getProductList().isEmpty());
    }
}
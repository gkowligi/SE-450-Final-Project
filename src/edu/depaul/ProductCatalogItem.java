package edu.depaul;

public class ProductCatalogItem {
    private int _itemId;
    private String _itemName;
    private double _itemPrice;

    ProductCatalogItem(String itemId, String itemName, String itemPrice) {
        _itemId = Integer.parseInt(itemId);
        _itemName = itemName;
        _itemPrice = Double.parseDouble(itemPrice);
    }

    public int get_itemId() {
        return _itemId;
    }

    public String get_itemName() {
        return _itemName;
    }

    public double get_itemPrice() {
        return _itemPrice;
    }



    @Override
    public String toString() {
        return "ProductCatalogItem{" +
                "Item Id = " + _itemId +
                ", Item Name = '" + _itemName + '\'' +
                ", Item Price = " + _itemPrice +
                '}';
    }
}

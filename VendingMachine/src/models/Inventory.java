package models;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> productQuantities = new HashMap<>();

    public void addProduct(Product product, int quantity){
        productQuantities.put(product.getName(),
                productQuantities.getOrDefault(product.getName(),0) + quantity);
    }

    public boolean hasProduct(String productName){
        return productQuantities.getOrDefault(productName, 0) > 0;
    }

    public void reduceQuantity(String productName){
        productQuantities.put(productName, productQuantities.get(productName)-1);
    }

    public int getQuantity(String productName){
        return productQuantities.getOrDefault(productName, 0);
    }

    public void displayInventory() {
        for(Map.Entry<String, Integer> entry: productQuantities.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

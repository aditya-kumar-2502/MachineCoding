package models;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<String, Product> products = new HashMap<>();
    private Inventory inventory = new Inventory();
    private int currentBalance = 0;
    private Product selectedProduct = null;

    public void addProduct(Product product, int quantity) {
        products.put(product.getName(), product);
        inventory.addProduct(product, quantity);
    }

    public void insertCoin(Coin coin){
        currentBalance += coin.getValue();
        System.out.println("Inserted coin: " + coin + ", Current balance: " + currentBalance);
    }

    public void selectProduct(String productName){
        if(!products.containsKey(productName)) {
            System.out.println("Product not found.");
            return;
        }
        if(!inventory.hasProduct(productName)){
            System.out.println("Product out of stock.");
            return;
        }
        selectedProduct = products.get(productName);
        if(currentBalance < selectedProduct.getPrice()){
            System.out.println("Insufficient balance. Please insert more coins.");
            return;
        } else {
            System.out.println("Product selected: " + selectedProduct.getName());
        }
    }

    public void dispenseProduct() {
        if(selectedProduct == null){
            System.out.println("Please select a product first.");
            return;
        }
        if(currentBalance < selectedProduct.getPrice()){
            System.out.println("Insufficient balance. Please insert more coins.");
            return;
        }
        currentBalance -= selectedProduct.getPrice();
        inventory.reduceQuantity(selectedProduct.getName());
        System.out.println("Dispensing product: " + selectedProduct.getName());
        if(currentBalance > 0){
            System.out.println("Returning change: " + currentBalance);
            currentBalance = 0;
        }
        selectedProduct = null;
    }

    public void refund(){
        if(currentBalance > 0){
            System.out.println("Refunding balance: " + currentBalance);
            currentBalance = 0;
        }  else{
            System.out.println("No balance to refund.");
        }
    }

    public void displayProducts(){
        System.out.println("Available products:");
        for(Map.Entry<String, Product> entry: products.entrySet()){
            System.out.println(entry.getKey() + " - Price: " + entry.getValue().getPrice()
                    + "-Quantity: " + inventory.getQuantity(entry.getKey()));
        }
    }
}

import models.Coin;
import models.Product;
import models.VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.addProduct(new Product("Coke", 50), 5);
        vm.addProduct(new Product("Pepsi", 45), 2);
        vm.addProduct(new Product("Soda", 60), 3);

        vm.displayProducts();

        // Simulate user
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);

        vm.selectProduct("Coke");
        vm.dispenseProduct();

        vm.refund();
    }
}
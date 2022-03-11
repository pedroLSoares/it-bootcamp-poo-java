package Inheritance;

import java.util.List;

public class Distributor {

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Perishable("Mayonese", 8.00, 6),
                new Perishable("Milk", 3.49, 2),
                new NonPerishable("Pasta", 1.50, "Food"));

        for(Product product: products){
            System.out.println(product);
            Double value = product.calculate(5);
            System.out.println("Final price: R$ " + value + "\n");
        }
    }
}

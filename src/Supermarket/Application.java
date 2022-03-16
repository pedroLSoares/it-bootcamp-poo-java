package Supermarket;

import Supermarket.Model.Customer;
import Supermarket.Service.TerminalMarketService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer(1, "Pedro", "Soares"));
        customers.add(new Customer(2, "Joao", "Silva"));
        customers.add(new Customer(3, "Mario", "Andrade"));

        customers.forEach(System.out::println);

        TerminalMarketService tms = new TerminalMarketService();
        tms.run();





    }
}

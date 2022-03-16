package Supermarket.Model;

import Generics.Veichle;

import java.math.BigDecimal;
import java.util.List;

public class Invoice {
    private int ID;
    private final Customer customer;
    private List<Item> items;
    private BigDecimal totalPrice;

    public Invoice(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
        totalPrice = items.stream()
                .map(item -> item.getUnitCost().multiply(new BigDecimal(item.getQtyBought())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "ID=" + ID +
                ", customer=" + customer +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

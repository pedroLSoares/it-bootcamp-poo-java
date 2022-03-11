package Inheritance;

import java.math.BigDecimal;

abstract class Product {
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double calculate(int productsQty) {
        BigDecimal price = new BigDecimal(this.price.toString());
        return price.multiply(new BigDecimal(productsQty)).doubleValue();
    }

    @Override
    public String toString() {
        return "Produto: " + name + "\nPreco: R$ " + price + "\n";
    }
}

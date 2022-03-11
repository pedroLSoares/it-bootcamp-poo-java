package Inheritance;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Perishable extends Product {

    private Integer daysToGo;

    public Perishable(String name, Double price,int daysToGo) {
        super(name, price);
        this.daysToGo = daysToGo;
    }


    @Override
    public Double calculate(int productsQty) {
        BigDecimal price = new BigDecimal(getPrice().toString());

        int valueToDivide = daysToGo > 3 ? 1 : 5 - daysToGo;

        BigDecimal value = price.divide(new BigDecimal(valueToDivide), 2, RoundingMode.HALF_DOWN);

        return value.multiply(new BigDecimal(productsQty)).doubleValue();
    }

    public int getDaysToGo() {
        return daysToGo;
    }

    public void setDaysToGo(int daysToGo) {
        this.daysToGo = daysToGo;
    }

    @Override
    public String toString() {
        return "Perecível{" +
                "\nNome: " + getName() +
                "\ndaysToGo=" + daysToGo +
                "\nPreco: " + getPrice() +
                '}';
    }
}

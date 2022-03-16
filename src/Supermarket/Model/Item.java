package Supermarket.Model;

import java.math.BigDecimal;

public class Item {
    private String code;
    private String name;
    private BigDecimal unitCost;
    private int qtyBought;

    public Item(String code, String name, BigDecimal unitCost) {
        this.code = code;
        this.name = name;
        this.unitCost = unitCost;
    }

    public Item(String code, String name, BigDecimal unitCost, int qtyBought) {
        this.code = code;
        this.name = name;
        this.unitCost = unitCost;
        this.qtyBought = qtyBought;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setQtyBought(int qtyBought) {
        this.qtyBought = qtyBought;
    }

    public int getQtyBought() {
        return qtyBought;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", unitCost=" + unitCost +
                ", qtyBought=" + qtyBought +
                '}';
    }
}

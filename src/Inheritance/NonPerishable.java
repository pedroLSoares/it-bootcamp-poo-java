package Inheritance;

public class NonPerishable extends Product{

    private String type;

    public NonPerishable(String name, Double price, String type) {
        super(name, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Não perecivel {" +
                "\nNome: " + getName() +
                "\nTipo: " + type + '\'' +
                "\nPreco: " + getPrice() +
                '}';
    }
}

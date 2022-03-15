package Generics;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private int ID;
    private List<Veichle> veichles;

    public Garage(int ID, List<Veichle> veichles) {
        this.ID = ID;
        this.veichles = veichles;
    }

    public Garage(int ID) {
        this.ID = ID;
        this.veichles = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Veichle> getVeichles() {
        return veichles;
    }

    public void setVeichles(List<Veichle> veichles) {
        this.veichles = veichles;
    }

    public boolean pushVeichle(Veichle veichle){
        return veichles.add(veichle);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "ID=" + ID +
                ", veichles=" + veichles +
                '}';
    }
}

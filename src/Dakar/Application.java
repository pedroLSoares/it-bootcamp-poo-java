package Dakar;

import Dakar.Model.*;
import Generics.Veichle;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        Race race = new Race(1200, new BigDecimal(15000), "Corrida 1", 3);
        Car car1 = new Car(200, 3000, 90, "ABC1234");
        Car car2 = new Car(110, 6000, 60, "DDC1234");
        Motorcycle motorcycle1 = new Motorcycle(230, 5000, 60, "FFF9988");
        Motorcycle motorcycle2 = new Motorcycle(210, 5200, 65, "FFF9987");

        race.addVehicle(car1);
        race.addVehicle(motorcycle1);
        race.addVehicle(motorcycle2);
        race.addVehicle(car2);
        race.addVehicle(car1);

        race.rescueCar("ABC1234");
        race.rescueCar("FFF9988");

        Vehicle winner = race.chooseWinner();

        System.out.println(winner);
    }
}

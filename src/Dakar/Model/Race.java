package Dakar.Model;

import Generics.Veichle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Race {

    private final double distance;
    private final BigDecimal dolarPrize;
    private final String name;
    private final int maxVeichlesNumber;
    private final List<Vehicle> veichles = new ArrayList<>();

    private final LifeguardCar lifeguardCar = new LifeguardCar();
    private final LifeguardMotorcycle lifeguardMotorcycle = new LifeguardMotorcycle();

    public Race(double distance, BigDecimal dolarPrize, String name, int maxVeichlesNumber) {
        this.distance = distance;
        this.dolarPrize = dolarPrize;
        this.name = name;
        this.maxVeichlesNumber = maxVeichlesNumber;
    }

    public void addVehicle(Vehicle vehicle){
        if(veichles.size() == maxVeichlesNumber) {
            System.out.println("List lotada");
            return;
        }

        if(veichles.contains(vehicle)){
            System.out.println("Veículo já adicionado");
            return;
        }
        veichles.add(vehicle);

    }

    public void addCar(Car car){
        if(veichles.size() == maxVeichlesNumber) {
            System.out.println("List lotada");
            return;
        }

        if(veichles.contains(car)){
            System.out.println("Carro já adicionado");
            return;
        }
        veichles.add(car);
    }

    public void addMotorCycle(Motorcycle motorcycle){
        if(veichles.size() == maxVeichlesNumber) {
            System.out.println("List lotada");
            return;
        }

        if(veichles.contains(motorcycle)){
            System.out.println("Moto já adicionado");
            return;
        }
        veichles.add(motorcycle);
    }

    public boolean removeVehicle(Vehicle vehicle){
        return veichles.remove(vehicle);
    }

    public boolean removeByPlate(String plate){
        return veichles.removeIf(v -> v.getPlate().equals(plate));
    }

    public Vehicle chooseWinner(){
       Vehicle winner = null;
       double value = 0;

       for(Vehicle vehicle: veichles){
           double calc = vehicle.getSpeed() * (vehicle.getAcceleration() / 2.0) / (vehicle.getRotationAngle() * (vehicle.getWeight() - vehicle.getWheels() * 100));

           if(calc > value){
               winner = vehicle;
               value = calc;
           }
       }

       return winner;
    }

    public void rescueCar(String plate){
        Optional<Vehicle> carOptional = findVeichleByPlate(plate);

        if(carOptional.isEmpty()){
            System.out.println("Veículo com a placa " + plate + " não encontrado");
            return;
        }
        if(!(carOptional.get() instanceof Car)){
            System.out.println("O veículo não é um carro");
            return;
        }

        lifeguardCar.rescue((Car) carOptional.get());
    }

    public void rescueMotorcycle(String plate){
        Optional<Vehicle> motoOptional = findVeichleByPlate(plate);

        if(motoOptional.isEmpty()){
            System.out.println("Veículo com a placa " + plate + " não encontrado");
            return;
        }
        if(!(motoOptional.get() instanceof Motorcycle)){
            System.out.println("O veículo não é uma moto");
            return;
        }

        lifeguardMotorcycle.rescue((Motorcycle) motoOptional.get());
    }

    private Optional<Vehicle> findVeichleByPlate(String plate){
        return veichles.stream().filter(c -> c.getPlate().equals(plate)).findFirst();
    }

    public double getDistance() {
        return distance;
    }

    public BigDecimal getDolarPrize() {
        return dolarPrize;
    }

    public String getName() {
        return name;
    }

    public int getMaxVeichlesNumber() {
        return maxVeichlesNumber;
    }

    public List<Vehicle> getVeichles() {
        return veichles;
    }

    @Override
    public String toString() {
        return "Race{" +
                "distance=" + distance +
                ", dolarPrize=" + dolarPrize +
                ", name='" + name + '\'' +
                ", maxVeichlesNumber=" + maxVeichlesNumber +
                ", veichles=" + veichles +
                ", lifeguardCar=" + lifeguardCar +
                ", lifeguardMotorcycle=" + lifeguardMotorcycle +
                '}';
    }
}

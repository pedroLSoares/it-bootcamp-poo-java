package Dakar.Model;

public class Motorcycle extends Vehicle{
    private static final double WEIGHT = 300;
    private static final int WHEELS = 2;

    public Motorcycle(int speed, int acceleration, double rotationAngle, String plate) {
        super(speed, acceleration, rotationAngle, plate, WEIGHT, WHEELS);
    }
}

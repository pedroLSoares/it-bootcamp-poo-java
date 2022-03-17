package Dakar.Model;

public class Car extends Vehicle {
    private static final double CAR_WEIGHT = 1000;
    private static final int CAR_WHEELS = 4;

    public Car(int speed, int acceleration, double rotationAngle, String plate) {
        super(speed, acceleration, rotationAngle, plate, CAR_WEIGHT, CAR_WHEELS);
    }
}

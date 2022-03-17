package Dakar.Model;

public abstract class Vehicle {

    protected int speed;
    protected int acceleration;
    protected double rotationAngle;
    protected String plate;
    protected double weight;
    protected int wheels;

    public Vehicle(int speed, int acceleration, double rotationAngle, String plate, double weight, int wheels) {
        this.speed = speed;
        this.acceleration = acceleration;
        this.rotationAngle = rotationAngle;
        this.plate = plate;
        this.weight = weight;
        this.wheels = wheels;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public double getRotationAngle() {
        return rotationAngle;
    }

    public String getPlate() {
        return plate;
    }

    public double getWeight() {
        return weight;
    }

    public int getWheels() {
        return wheels;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "speed=" + speed +
                ", acceleration=" + acceleration +
                ", rotationAngle=" + rotationAngle +
                ", plate='" + plate + '\'' +
                ", weight=" + weight +
                ", wheels=" + wheels +
                '}';
    }
}

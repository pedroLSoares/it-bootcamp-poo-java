package AbstractClasseAndInterfaces.Animals;

public class Dog extends Animal implements Carnivore{
    @Override
    public void eatMeat() {
        System.out.println("Eating meat...");
    }

    @Override
    public void eatAnimal(Animal animal) {
        System.out.println("Eating " + animal.getClass().getName());
    }

    @Override
    public void emitSound() {
        System.out.println("Au au");
    }
}

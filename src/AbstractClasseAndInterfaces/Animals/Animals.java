package AbstractClasseAndInterfaces.Animals;

public class Animals {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        dog.emitSound();
        cat.emitSound();
        cow.emitSound();

        dog.eatAnimal(cow);
    }
}

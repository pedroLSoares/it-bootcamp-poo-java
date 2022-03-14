package AbstractClasseAndInterfaces.Animals;

public class Cow extends Animal implements Herbivore{
    @Override
    public void eatGrass() {
        System.out.println("Eating grass...");
    }

    @Override
    public void emitSound() {
        System.out.println("Moooo");
    }
}

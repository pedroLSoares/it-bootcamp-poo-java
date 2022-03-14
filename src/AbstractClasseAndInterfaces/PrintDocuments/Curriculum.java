package AbstractClasseAndInterfaces.PrintDocuments;

import Classes.Person;

import java.util.List;

public class Curriculum extends Document{
    private Person person;
    private List<String> abilities;

    public Curriculum(String fileName) {
        super(fileName);
    }

    public Curriculum setPerson(Person person) {
        this.person = person;
        return this;
    }

    public Curriculum setAbilities(List<String> abilities) {
        this.abilities = abilities;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public List<String> getAbilities() {
        return abilities;
    }
}

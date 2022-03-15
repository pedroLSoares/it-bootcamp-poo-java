package AbstractClasseAndInterfaces.PrintDocuments;

import Classes.Ability;
import Classes.Person;

import java.util.List;

public class Curriculum implements Document{
    private Person person;
    private List<Ability> abilities;

    public Curriculum setPerson(Person person) {
        this.person = person;
        return this;
    }

    public Curriculum setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public DocumentObject getContent() {
        return new DocumentObject(person.toString(), abilities.toString(), 1);
    }
}

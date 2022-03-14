package Classes;

public class Ability {
    private String name;
    private int level;

    public Ability(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}

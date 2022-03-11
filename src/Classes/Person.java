package Classes;

import java.util.HashMap;
import java.util.Map;

public class Person {

    private String ID;
    private String name;
    private Integer age;
    private Integer height;
    private Double weight;

    public Person() {

    }

    public Person(String ID, String name, int age) {
        this.ID = ID;
        this.name = name;
        this.age = age;
    }

    public Person(String ID, String name, int age, int height, double weight) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public int calculateIMC(){
        double imc = weight / Math.pow(((double) height / 100), 2);

        if(imc < 20){
            return -1;
    }
        return imc >= 20 && imc <= 25 ? 0 : 1;

    }

    public boolean isOfAge(){
        return age >= 18;
    }

    @Override
    public String toString() {
        Map<String, String> infos = new HashMap<>();

        infos.put("ID", ID);
        infos.put("Nome", name);
        infos.put("Idade", age.toString());
        infos.put("Altura", height.toString());
        infos.put("Peso", weight.toString());

        return infos.toString();
    }
}

package Classes;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void showImcMessage(int imc){
        Map<Integer, String> imcMessages = new HashMap<>();
        imcMessages.put(-1, "Abaixo do peso");
        imcMessages.put(0, "Peso saudável");
        imcMessages.put(1, "Sobrepeso");

        System.out.println(imcMessages.get(imc));
    }

    public static void calculateIMC(){
        Person emptyPerson = new Person();
        Person emptyMetrics = new Person("1", "Pedro", 22);
        Person person = new Person("2", "Jonas", 23, 180, 75.4);

        boolean isOfAge = person.isOfAge();

        String ageMessage = isOfAge ? "Maior de idade" : "Menor de idade";
        System.out.println(ageMessage);

        int imc = person.calculateIMC();
        showImcMessage(imc);
    }

    public static void main(String[] args) {
        calculateIMC();
    }
}

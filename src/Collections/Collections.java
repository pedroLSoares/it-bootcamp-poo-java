package Collections;

import java.util.*;

public class Collections {

    public static Map<String, Integer> buildTempMap( int lowerTemperature, int higherTemperature){
        return Map.ofEntries(Map.entry("lowerTemperature", lowerTemperature), Map.entry("higherTemperature", higherTemperature));
    }

    public static void findMaxAndMinTemperature(){
        Map<String, Map<String, Integer>> cities = new HashMap<>();
        cities.put("London", buildTempMap(-2, 33));
        cities.put("Madrid", buildTempMap(-3, 32));
        cities.put("New York", buildTempMap(-8, 27));
        cities.put("Buenos Aires", buildTempMap(4, 37));
        cities.put("Asunción", buildTempMap(6, 42));
        cities.put("São Paulo", buildTempMap(5, 43));
        cities.put("Lima", buildTempMap(0, 39));
        cities.put("Santiago do Chile", buildTempMap(-7, 26));
        cities.put("Lisboa", buildTempMap(-1, 31));
        cities.put("Tokio", buildTempMap(-10, 35));


        String higherTempCity = "";
        int higherTemperature = 0;
        String lowerTempCity = "";
        int lowerTemperature = 0;
        for(var city:cities.entrySet()){
            String cityName = city.getKey();
            int minTemp = city.getValue().get("lowerTemperature");
            int maxTemp = city.getValue().get("higherTemperature");

            if(higherTempCity.isEmpty() || maxTemp > higherTemperature){
                higherTemperature = maxTemp;
                higherTempCity = cityName;
            }

            if(lowerTempCity.isEmpty() || minTemp < lowerTemperature){
                lowerTemperature = minTemp;
                lowerTempCity = cityName;
            }

        }

        System.out.format("A cidade com maior temperatura foi %s com %d C\n", higherTempCity, higherTemperature);
        System.out.format("A cidade com menor temperatura foi %s com %d C", lowerTempCity, lowerTemperature);
    }

    public static void racingUsingClasses(){
        JungleRace smallCircuit = new JungleRace(2, "Circuito pequeno", "Selva e riachos");
        JungleRace mediumCircuit = new JungleRace(5, "Circuito médio", "Selva, riachos e lama");
        JungleRace advancedCircuit = new JungleRace(10, "Circuito avancado", "Selva, riachos, lama e escalada");



        Participant p1 = new Participant(112223334, "Pedro", "Levada", 22, 1140028922, 1140028922, "O-");

        smallCircuit.addParticipantAndReturnTax(p1);
        smallCircuit.addParticipantAndReturnTax(p1);
        smallCircuit.addParticipantAndReturnTax(new Participant(772223339, "Marcio", "Levada", 22, 1140028922, 1140028922, "O-"));

        advancedCircuit.addParticipantAndReturnTax(new Participant(772223334, "Rogerio", "Levada", 22, 1140028922, 1140028922, "O-"));


        System.out.println(smallCircuit.participants);

        smallCircuit.removeParticipant(p1);

        System.out.println(smallCircuit.participants);
        System.out.println(advancedCircuit.participants);

    }

    public static void racingScanner(){

        JungleRaceScanner jungleScanner = new JungleRaceScanner();

        jungleScanner.startConsole();

    }

    public static void main(String[] args) {
//        findMaxAndMinTemperature();
         racingUsingClasses();
        //racingScanner();
    }
}

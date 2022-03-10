import netscape.javascript.JSObject;

import java.util.*;

public class Application {
    public static void firstImplementation(){
        String cities[] = new String[10];
        cities[0] = "London";
        cities[1] = "Madrid";
        cities[2] = "New York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asunción";
        cities[5] = "São Paulo";
        cities[6] = "Lima";
        cities[7] = "Santiago de Chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";

        int temperatures[][] = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };


        String higherTempCity = "";
        int higherTemperature = 0;
        String lowerTempCity = "";
        int lowerTemperature = 0;

        for(int i = 0; i < cities.length; i++){
            String city = cities[i];
            int maxTemp = temperatures[i][1];
            int minTemp = temperatures[i][0];

            if(higherTempCity.isEmpty() || maxTemp > higherTemperature){
                higherTemperature = maxTemp;
                higherTempCity = city;
            }

            if(lowerTempCity.isEmpty() || minTemp < lowerTemperature){
                lowerTemperature = minTemp;
                lowerTempCity = city;
            }
        }

        System.out.format("A cidade com maior temperatura foi %s com %d C\n", higherTempCity, higherTemperature);
        System.out.format("A cidade com menor temperatura foi %s com %d C", lowerTempCity, lowerTemperature);
    }

    public static Map<String, Integer> buildTempMap( int lowerTemperature, int higherTemperature){
        return Map.ofEntries(Map.entry("lowerTemperature", lowerTemperature), Map.entry("higherTemperature", higherTemperature));
    }

    public static void collectionImplementation(){
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

    public static void main(String[] args) {
//        firstImplementation();
        collectionImplementation();

    }


}

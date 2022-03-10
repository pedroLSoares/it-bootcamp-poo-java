package Arrays;

import netscape.javascript.JSObject;

import java.util.*;

public class Arrays {
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



    public static void main(String[] args) {
       firstImplementation();

    }


}

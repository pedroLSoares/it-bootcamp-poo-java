package Generics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void populateGarage(Garage garage){
        Map<String, List<Map<String, Object>>> cars = new HashMap<>();
        cars.put("Ford", List.of(
                Map.of("model", "Fiesta", "Price", 1000),
                Map.of("model", "Focus", "Price", 1200),
                Map.of("model", "Explorer", "Price", 2500)
        ));
        cars.put("Fiat", List.of(
                Map.of("model", "Uno", "Price",500),
                Map.of("model", "Cronos", "Price", 1000),
                Map.of("model", "Torino", "Price", 1250)
        ));

        cars.put("Chevrolet", List.of(
                Map.of("model", "Aveo", "Price", 1250),
                Map.of("model", "Spin", "Price", 2500)
        ));

        cars.put("Toyota", List.of(
                Map.of("model", "Corola", "Price", 1200),
                Map.of("model", "Fortuner", "Price", 3000)
        ));

        cars.put("Renault", List.of(
                Map.of("model", "Logan", "Price", 950)
        ));

        for(var entry: cars.entrySet()){
            List<Map<String, Object>> carsList = entry.getValue();
            carsList.forEach(car -> {
                Veichle veichle = new Veichle(car.get("model").toString(), entry.getKey(), new BigDecimal(car.get("Price").toString()));
                garage.pushVeichle(veichle);
            });
        }
    }

    public static void main(String[] args) {

        Garage garage = new Garage(1);
        populateGarage(garage);

        List<Veichle> sortedByPrice =  garage.getVeichles().stream().sorted(Comparator.comparing(Veichle::getPrice)).collect(Collectors.toList());
        List<Veichle> sortedByBrand =  garage.getVeichles().stream().sorted(Comparator.comparing(Veichle::getBrand)).collect(Collectors.toList());
        List<Veichle> below1000 = garage.getVeichles().stream().filter(veichle -> veichle.getPrice().compareTo(new BigDecimal(1000)) < 0).collect(Collectors.toList());
        List<Veichle> higher1000 = garage.getVeichles().stream().filter(veichle -> veichle.getPrice().compareTo(new BigDecimal(1000)) > 0 || veichle.getPrice().compareTo(new BigDecimal(1000)) == 0).collect(Collectors.toList());
        BigDecimal mediumValue = garage.getVeichles().stream()
                .map(Veichle::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(garage.getVeichles().size()), 2, RoundingMode.HALF_EVEN);


        System.out.println("Original" + garage.getVeichles());
        System.out.println("By Price: " + sortedByPrice);
        System.out.println("By brand: " + sortedByBrand);
        System.out.println("Below 1000: " + below1000);
        System.out.println("Higher 1000: " + higher1000);
        System.out.println("Valor médio: R$ " + mediumValue);
    }
}

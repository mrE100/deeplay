package deeplay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = loadAnimalsFromFile("animals.txt");
        AnimalManager animalManager = new AnimalManager(animals);
        Rule isHerbivore = new Rule("травоядное", Map.of("ТИП", "ТРАВОЯДНОЕ"));
        Rule isCarnivoreAndSmall = new Rule("плотоядное и маленькое",
                Map.of("ТИП", "ПЛОТОЯДНОЕ", "РОСТ", "МАЛЕНЬКОЕ"));
        Rule isOmnivoreAndSmall = new Rule("всеядное и маленькое",
                Map.of("ТИП", "ВСЕЯДНОЕ", "РОСТ", "МАЛЕНЬКОЕ"));
        Rule isOmnivoreAndNotTall = new Rule("всеядное и невысокое",
                Map.of("ТИП", "ВСЕЯДНОЕ", "РОСТ", "НЕВЫСОКОЕ"));
        System.out.println("Количество травоядных: " + animalManager.countAnimalsByRules(List.of(isHerbivore)));
        System.out.println("Количество плотоядных или всеядных и маленьких: " + animalManager.countAnimalsByRules(
                List.of(isCarnivoreAndSmall, isOmnivoreAndSmall)
        ));
        System.out.println("Количество всеядных, но не высоких: " + animalManager.countAnimalsByRules(
                List.of(isOmnivoreAndSmall, isOmnivoreAndNotTall)
        ));
    }

    private static List<Animal> loadAnimalsFromFile(String filename) {
        List<Animal> animals = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                List<Property> properties = new ArrayList<>();
                properties.add(new Property("ВЕС", parts[0]));
                properties.add(new Property("РОСТ", parts[1]));
                properties.add(new Property("ТИП", parts[2]));
                animals.add(new Animal(properties));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animals;
    }
}

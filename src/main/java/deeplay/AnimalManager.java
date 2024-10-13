package deeplay;

import java.util.List;

public class AnimalManager {
    private List<Animal> animals;

    public AnimalManager(List<Animal> animals) {
        this.animals = animals;
    }
    public int countAnimalsByRules(List<Rule> rules) {
        int count = 0;
        for (Animal animal : animals) {
            for (Rule rule : rules) {
                if (rule.evaluate(animal)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}

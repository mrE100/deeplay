package deeplay;

import java.util.Map;

public class Rule {
    private String description;
    private Map<String, String> conditions;


    public Rule(String description, Map<String, String> conditions) {
        this.description = description;
        this.conditions = conditions;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getConditions() {
        return conditions;
    }

    public boolean evaluate(Animal animal) {
        boolean isConditionMet = false;
        for (String key : conditions.keySet()) {
            if (animal.getProperty(key).equals(conditions.get(key))) {
                isConditionMet = true;
            } else {
                isConditionMet = false;
                break;
            }
        }
        return isConditionMet;
    }
}

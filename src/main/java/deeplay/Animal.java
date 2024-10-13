package deeplay;

import java.util.List;

public class Animal {
    private List<Property> properties;

    public Animal(List<Property> properties) {
        this.properties = properties;
    }

    public String getProperty(String name) {
        for (Property property : properties) {
            if (property.getName().equals(name)) {
                return property.getValue();
            }
        }
        return null;
    }
}

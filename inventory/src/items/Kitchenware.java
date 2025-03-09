package items;

public class Kitchenware {
    String name;
    public Kitchenware(String name) {
        setName(name);
    }
    public Kitchenware() {
        setName("None");
    }
    void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return name;
    }
}

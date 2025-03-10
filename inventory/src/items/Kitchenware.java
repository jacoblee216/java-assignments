package items;

public class Kitchenware {
    String name;
    boolean sharp;
    public Kitchenware(String name, boolean sharp) {
        this.name = name;
        this.sharp = sharp;
    }
    public boolean getSharp() {
        return sharp;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return name;
    }
}

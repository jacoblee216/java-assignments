package items;

public class cleanSupplies {
    protected String name;
    protected boolean liquid;
    protected boolean electric;
    
    public cleanSupplies(String name, boolean liquid, boolean electric) {
        setName(name);
        setLiquid(liquid);
        setElectric(electric);
    }
    public cleanSupplies() {
        setName("None");
        setLiquid(false);
        setElectric(false);
    }
    void setName(String name) {
        this.name = name;
    }
    void setLiquid(boolean liquid) {
        this.liquid = liquid;
    }
    void setElectric(boolean electric) {
        this.electric = electric;
    }

    String getName() {
        return name;
    }
    boolean getLiquid() {
        return liquid;
    }

    boolean getElectric() {
        return electric;
    }
    public String toString() {
        return "Cleaning Supplies Name: " + name + "\nLiquid: " + liquid + "\nElectric: " + electric;
    }
}

package items;

public class nonLiquidClean extends cleanSupplies {
    public nonLiquidClean(String name, boolean electric) {
        this.name = name;
        this.electric = electric;

    }
    public boolean isElectric() {
        return electric;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        if (electric) {
            return name + " | " + "ELECTRIC"; // add electric to the name if electric is true
        } else {
            return name;
        }
    }
    
}

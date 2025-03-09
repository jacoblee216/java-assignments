package items;

public class nonLiquidClean extends cleanSupplies {
    public nonLiquidClean(String name, boolean electric) {
        this.name = name;
        this.electric = electric;

    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        if (electric) {
            return name + " | " + "ELECTRIC";
        } else {
            return name;
        }
    }
    
}

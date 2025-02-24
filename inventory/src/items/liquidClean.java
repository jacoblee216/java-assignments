package items;
public class liquidClean extends cleanSupplies {
    private boolean toxic;

    public liquidClean(String name, boolean liquid, boolean electric, boolean toxic) {
        super(name, liquid, electric);
        this.toxic = toxic;
    }
    public liquidClean() {
        super();
    }
    public boolean isToxic() {
        return toxic;
    }
    public String toString() {
        return "Liquid Cleaning Supplies Name: " + name + "\nLiquid: " + liquid + "\nElectric: " + electric;
    }
}

package items;
public class liquidClean extends cleanSupplies {
    private boolean toxic;
    private boolean laundry;
    public liquidClean(String name, boolean toxic, boolean laundry) {
        this.name = name;
        this.toxic = toxic;
        this.laundry = laundry;
    }
    public boolean isToxic() {
        return toxic;
    }
    public boolean isLaundry() {
        return laundry;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        if (toxic) {
            return name + " | " + "TOXIC" ; // adds toxic to the name if toxic is true
        } else {
            return name;
        }
    }
}

package items;
public class liquidClean extends cleanSupplies {
    private boolean toxic;

    public liquidClean(String name, boolean toxic) {
        this.name = name;
        this.toxic = toxic;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        if (toxic) {
            return name + " | " + "TOXIC" ;
        } else {
            return name;
        }
    }
}

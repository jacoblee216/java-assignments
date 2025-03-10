package items;

public class Food {

    private String foodName;
    private boolean meat;
    private boolean dairy;

    public Food(String foodName, boolean meat, boolean dairy) {
        this.foodName = foodName;
        this.meat = meat;
        this.dairy = dairy;
    }
    public boolean isMeat() {
        return meat;
    }
    public boolean isDairy() {
        return dairy;
    }
    public String getFoodName() {
        return foodName;
    }
    public String toString() {
        return foodName;
    }
}

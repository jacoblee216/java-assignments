package items;

public class Food {
    String foodType;
    String foodName;
    public Food(String foodType, String foodName) {
        setFoodType(foodType);
        setFoodName(foodName);
    }
    public Food() {
        setFoodType("None");
        setFoodName("None");
    }
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public String getFoodType() {
        return foodType;
    }
    public String getFoodName() {
        return foodName;
    }
    public String toString() {
        return "Food Type: " + foodType + "\nFood Name: " + foodName;
    }
}

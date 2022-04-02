package main.java.com.solvd.animals;

public class Food {
    private String foodName;
    private int maxWeight;
    private String color;

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public Food(int maxWeight, String color) {
        this.maxWeight = maxWeight;
        this.color = color;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}

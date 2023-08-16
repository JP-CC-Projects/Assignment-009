package domain;
import java.math.BigDecimal;

public class Recipe {
    private Integer cookingMinutes; //0
    private Boolean dairyFree; //1
    private Boolean glutenFree; //2
    private String instructions; //3
    private Integer preparationMinutes; //4
    private BigDecimal pricePerServing; //5
    private Integer readyInMinutes; //6
    private Double servings;
    private Double spoonacularScore;
    private String title;
    private Boolean vegan;
    private Boolean vegetarian;

    public Recipe (String[] stringArr){
        this.cookingMinutes = Integer.parseInt(stringArr[0]);
        this.dairyFree = Boolean.parseBoolean(stringArr[1]);
        this.glutenFree = Boolean.parseBoolean(stringArr[2]);
        this.instructions = stringArr[3];
        this.preparationMinutes = Integer.parseInt(stringArr[4]);
        this.pricePerServing = new BigDecimal(stringArr[5]);
        this.readyInMinutes = Integer.parseInt(stringArr[6]);
        this.servings = Double.parseDouble(stringArr[7]);
        this.spoonacularScore = Double.parseDouble(stringArr[8]);
        this.title = stringArr[9];
        this.vegan = Boolean.parseBoolean(stringArr[10]);
        this.vegetarian = Boolean.parseBoolean(stringArr[11]);
    }

    public Integer getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(Integer cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    public Boolean getDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(Boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Integer getPreparationMinutes() {
        return preparationMinutes;
    }

    public void setPreparationMinutes(Integer preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }

    public BigDecimal getPricePerServing() {
        return pricePerServing;
    }

    public void setPricePerServing(BigDecimal pricePerServing) {
        this.pricePerServing = pricePerServing;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public Double getServings() {
        return servings;
    }

    public void setServings(Double servings) {
        this.servings = servings;
    }

    public Double getSpoonacularScore() {
        return spoonacularScore;
    }

    public void setSpoonacularScore(Double spoonacularScore) {
        this.spoonacularScore = spoonacularScore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
}

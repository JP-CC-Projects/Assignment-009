package domain;
import java.math.BigDecimal;
import java.util.List;

public class Recipe {
    private Integer cookingMinutes; //0
    private Boolean dairyFree; //1
    private Boolean glutenFree; //2
    private String instructions; //3
    private Integer preparationMinutes; //4
    private BigDecimal pricePerServing; //5
    private Integer readyInMinutes; //6
    private Double servings; //7
    private Double spoonacularScore; //8
    private String title; //9
    private Boolean vegan; //10
    private Boolean vegetarian; //11
    public Recipe (){

    }
    public Recipe (List<String> stringArrList){
        this.cookingMinutes = Integer.parseInt(stringArrList.get(0));
        this.dairyFree = Boolean.parseBoolean(stringArrList.get(1));
        this.glutenFree = Boolean.parseBoolean(stringArrList.get(2));
        this.instructions = stringArrList.get(3);
        this.preparationMinutes = (int)Float.parseFloat(stringArrList.get(4));
        this.pricePerServing = new BigDecimal(stringArrList.get(5));
        this.readyInMinutes = Integer.parseInt(stringArrList.get(6));
        this.servings = Double.parseDouble(stringArrList.get(7));
        this.spoonacularScore = Double.parseDouble(stringArrList.get(8));
        this.title = stringArrList.get(9);
        this.vegan = Boolean.parseBoolean(stringArrList.get(10));
        this.vegetarian = Boolean.parseBoolean(stringArrList.get(11));
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

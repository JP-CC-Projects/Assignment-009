package com.jpassignments.assignment009.service;

import domain.Recipe;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.csv.*;

@Service
public class FileService {

    private List<List<String>> listOfListOfRecipeRecordsAsStringArrs = new ArrayList<>();
    private Iterable<CSVRecord> records;
    private List<String> headers;
    private final String fileName = "src/main/resources/recipes.txt";

    public Recipe getRecipeList() {
        return null;
    }

    public List<List<String>> getRecipeList(List<String> qualifiers, List<Boolean> bools) throws IOException {

        Reader in = new FileReader(fileName);
        CSVFormat csvFormat = customCSVFormatBuilder();
        this.records = csvFormat.parse(in);
        this.headers = getHeaders(this.records);

        listOfListOfRecipeRecordsAsStringArrs.add(headers);
        List<Recipe> listOfRecipePOJOs = takeCSVRecordsConvertToPOJOs(this.records);
        List<Recipe> filteredRecipes = listOfRecipePOJOs;
        for (int i = 0; i < qualifiers.size(); i++) {
            final String qualifier = qualifiers.get(i);
            final boolean bool = bools.get(i);

            filteredRecipes = filteredRecipes
                    .stream()
                    .filter(recipe -> {
                        String property = getPropertyByHeader(recipe, qualifier);
                        return bool == Boolean.valueOf(property);
                    })
                    .toList();
        }
        for(Recipe recipe : filteredRecipes) {
            listOfListOfRecipeRecordsAsStringArrs.add(convertRecipeToStringArr(recipe));
        }
        return this.listOfListOfRecipeRecordsAsStringArrs;
    }
    public List<String> convertRecipeToStringArr(Recipe recipe) {
            List<String> recipeArrayList = new ArrayList<>();
            recipeArrayList.add(String.valueOf(recipe.getCookingMinutes()));
            recipeArrayList.add(String.valueOf(recipe.getDairyFree()));
            recipeArrayList.add(String.valueOf(recipe.getGlutenFree()));
            recipeArrayList.add(recipe.getInstructions());
            recipeArrayList.add(String.valueOf(recipe.getPreparationMinutes()));
            recipeArrayList.add(recipe.getPricePerServing().toString());
            recipeArrayList.add(String.valueOf(recipe.getReadyInMinutes()));
            recipeArrayList.add(String.valueOf(recipe.getServings()));
            recipeArrayList.add(String.valueOf(recipe.getSpoonacularScore()));
            recipeArrayList.add(recipe.getTitle());
            recipeArrayList.add(String.valueOf(recipe.getVegan()));
            recipeArrayList.add(String.valueOf(recipe.getVegetarian()));
        return recipeArrayList;
    }

    public List<Recipe> takeCSVRecordsConvertToPOJOs(Iterable<CSVRecord> records) {
        List<Recipe> recipeList = new ArrayList<>();
        for (CSVRecord record : records) {
            recipeList.add(new Recipe(record.stream().toList()));
        }
        return recipeList;
    }

    public CSVFormat customCSVFormatBuilder() {
        CSVFormat inputCsvFormat = CSVFormat.DEFAULT.builder()
                .setEscape('\\')
                .setIgnoreSurroundingSpaces(true)
                .setHeader()
                .setTrim(true)
                .setSkipHeaderRecord(false)  // skip header
                .build();
        return inputCsvFormat;
    }

    public List<String> getHeaders(Iterable<CSVRecord> records) {

        List<String> headers = this.records
                .iterator()
                .next()
                .toMap()
                .keySet()
                .stream()
                .toList();
        return headers;
    }
    private String getPropertyByHeader(Recipe recipe, String header) {
        switch (header) {
            case "Cooking Minutes":
                return String.valueOf(recipe.getCookingMinutes());
            case "Dairy Free":
                return String.valueOf(recipe.getDairyFree());
            case "Gluten Free":
                return String.valueOf(recipe.getGlutenFree());
            case "Instructions":
                return recipe.getInstructions();
            case "Preparation Minutes":
                return String.valueOf(recipe.getPreparationMinutes());
            case "Price Per Serving":
                return String.valueOf(recipe.getPricePerServing());
            case "Ready In Minutes":
                return String.valueOf(recipe.getReadyInMinutes());
            case "Servings":
                return String.valueOf(recipe.getServings());
            case "Spoonacular Score":
                return String.valueOf(recipe.getSpoonacularScore());
            case "Title":
                return recipe.getTitle();
            case "Vegan":
                return String.valueOf(recipe.getVegan());
            case "Vegetarian":
                return String.valueOf(recipe.getVegetarian());
            default:
                return "";
        }
    }

}

package com.jpassignments.assignment009.service;

import domain.Recipe;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.csv.*;

@Service
public class FileService {

    private List<List<String>> listOfListOfRecipeRecordsAsStringArrs = new ArrayList<>();
    private Iterable<CSVRecord> records;
    List<String> headers;
    private final String fileName = "src/main/resources/recipes.txt";

    //No args constructor that returns all recipes.
    public Recipe getRecipeList() {
        return null;
    }

    //Helper class that takes a recipe property name and a boolean
    //converts it to an ArrayList of POJOs
    //and finally returns the Recipe POJOs as Strings
    public List<List<String>> getRecipeList(String qualifier, String bool) throws IOException {

        Reader in = new FileReader(fileName);
        CSVFormat csvFormat = customCSVFormatBuilder();
        this.records = csvFormat.parse(in);
        this.headers = getHeaders(this.records);
        //        add headers to private variable (listOfListOfRecipeRecordsAsStringArrs)
        //        that will be returned to the controller in the form of a List<List<String>>
        listOfListOfRecipeRecordsAsStringArrs.add(headers);
        List<Recipe> listOfRecipePOJOs = takeCSVRecordsConvertToPOJOs(this.records);
        List<String> stringers = getFilteredRecipeList(listOfRecipePOJOs, qualifier, bool);
//        System.out.println("List of Recipe POJO: " + listOfRecipePOJOs);

        return this.listOfListOfRecipeRecordsAsStringArrs;
    }
    //create a method that takes a List<Recipe>, a recipe property name and a boolean
    //and returns  a List<List<String>>
    //that will be returned to the controller in the form of a List<List<String>>

    public List<String> getFilteredRecipeList(List<Recipe> listOfRecipePOJOs, String qualifier, String bool) {

        List<String> stringArr = new ArrayList<>();
        for(Recipe recipePojo : listOfRecipePOJOs){
            if(recipePojo.getGlutenFree() == Boolean.parseBoolean(bool)){
                stringArr.add(String.valueOf(recipePojo.getCookingMinutes()));
                stringArr.add(String.valueOf(recipePojo.getDairyFree()));
                stringArr.add(String.valueOf(recipePojo.getGlutenFree()));
                stringArr.add(String.valueOf(recipePojo.getInstructions()));
                stringArr.add(String.valueOf(recipePojo.getPricePerServing()));
                stringArr.add(String.valueOf(recipePojo.getPreparationMinutes()));
                stringArr.add(String.valueOf(recipePojo.getServings()));
                stringArr.add(String.valueOf(recipePojo.getSpoonacularScore()));
                stringArr.add(String.valueOf(recipePojo.getTitle()));
                stringArr.add(String.valueOf(recipePojo.getVegan()));
                stringArr.add(String.valueOf(recipePojo.getVegetarian()));
            }
        }
        return stringArr;
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

}

package com.jpassignments.assignment009.service;

import domain.Recipe;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.csv.*;

@Service
//@Scope("prototype")
public class FileService {

    //No args constructor that returns all recipes.
    public static Recipe getRecipeList(){
        return null;
    }

    //Helper class that takes a recipe property name and a boolean
    //converts it to an ArrayList of POJOs
    //and finally returns the Recipe POJOs as Strings
    public static Recipe getRecipeList(String columnName, Boolean bool){

        return null;
    }


    public void fileService() throws IOException {
        Iterable<CSVRecord> convertedCsvRecords = recipeReaderTest();
        List<String> convertedStringArrList = csvRecordToStringArrList(convertedCsvRecords);
        Recipe recipePOJO = new Recipe(convertedStringArrList);
        System.out.println(recipePOJO);
    }

    public Iterable<CSVRecord> recipeReaderTest() throws IOException {
        Reader in = new FileReader("src/main/resources/recipes.txt");
        Iterable<CSVRecord> csvRecordList = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().withEscape('\\').parse(in);
        return csvRecordList;
    }

    public List<String> csvRecordToStringArrList(Iterable<CSVRecord> csvRecordList) {
        List<String> stringList = new ArrayList<>();
        for(CSVRecord csvRecord : csvRecordList){
            for(int i = 0; i < 11; i++){
                stringList.add(csvRecord.get(i));
            }
        }
        System.out.println(stringList);
        return stringList;
    }
        public List<String> csvRecordToStringArrList(CSVRecord csvRecord){
            List<String> stringArrList = new ArrayList<>();
            for (String s : csvRecord) {
            stringArrList.add(s);
        }
        return stringArrList;
    }



    public List<Recipe> parseFileAndReturnRecipeList(String fileName) throws IOException {
        List<String> recipeStringList = this.fileToStringList(fileName);
        List<Recipe> listOfRecipes = stringListToRecipeList(recipeStringList);
        return listOfRecipes;
    }
    public List<String> fileToStringList(String fileName) throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = "";

        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }
        return list;
    }

    public List<Recipe> stringListToRecipeList(List<String> recipeStringList) {
        List<Recipe> recipeList = new ArrayList<>();
        for (String recipeStringLine : recipeStringList) {
            String[] stringArr = recipeStringLine.split(",");
            Recipe recipe = new Recipe(stringArr);
            recipeList.add(recipe);
        }
        System.out.println(recipeList);
        return recipeList;
    }
}

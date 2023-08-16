package com.jpassignments.assignment009.service;

import domain.Recipe;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.*;

@Service
//@Scope("prototype")
public class FileService {

    public static void recipeReaderTest() throws IOException {
        Reader in = new FileReader("src/main/resources/recipes.txt");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().parse(in);
        for (CSVRecord record : records) {
            System.out.println(record.get(3));
        }
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
    public List<Recipe> filteredStringListToRecipeList(List<String> recipeStringList, String diet, Boolean bool) {
        List<Recipe> filteredRecipeList = new ArrayList<>();
        for (String recipeStringLine : recipeStringList) {
            String[] stringArr = recipeStringLine.split(",");
            Recipe recipe = new Recipe(stringArr);
            filteredRecipeList.add(recipe);
        }
        System.out.println(filteredRecipeList);
        return filteredRecipeList;
    }
}

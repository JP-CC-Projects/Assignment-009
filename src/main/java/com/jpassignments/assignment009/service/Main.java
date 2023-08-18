package com.jpassignments.assignment009.service;
import domain.Recipe;
import java.io.IOException;

import static com.jpassignments.assignment009.service.FileService.getRecipeList;

public class Main {
    public static void main(String[] args) throws IOException {
        Recipe recipe = new Recipe();
        recipe = getRecipeList("glutenFree", true);
        FileService recipePrinter = new FileService();
        recipePrinter.fileService();
    }
}

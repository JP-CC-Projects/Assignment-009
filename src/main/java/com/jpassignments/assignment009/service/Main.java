package com.jpassignments.assignment009.service;
import domain.Recipe;
import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("File Service = \n" + new FileService().getRecipeList(List.of("Vegetarian"), List.of(true)));
    }
}
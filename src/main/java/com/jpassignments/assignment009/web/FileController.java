package com.jpassignments.assignment009.web;

import com.jpassignments.assignment009.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

@RestController
public class FileController {
    @GetMapping("/all-recipes")
    public List<List<String>> allRecipes() throws IOException {
        return new FileService().getRecipeList(List.of(), List.of());
    }
    @GetMapping("/gluten-free")
    public List<List<String>> glutenFreeRecipes() throws IOException {
        return new FileService().getRecipeList(List.of("Gluten Free"), List.of(true));
    }

    @GetMapping("/vegan")
    public List<List<String>> veganRecipes() throws IOException {
        return new FileService().getRecipeList(List.of("Vegan"), List.of(true));
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<List<String>> veganAndGlutenFreeRecipes() throws IOException {
        return new FileService().getRecipeList(
                List.of("Vegan", "Gluten Free"),
                List.of(true, true));
    }

    @GetMapping("/vegetarian")
    public List<List<String>> vegetarianRecipes() throws IOException {
        return new FileService().getRecipeList(List.of("Vegetarian"), List.of(true));
    }




    @GetMapping("/")
    public List<List<String>> readLines() throws IOException {
        return null;
    }
}

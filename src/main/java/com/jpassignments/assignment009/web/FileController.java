package com.jpassignments.assignment009.web;

import com.jpassignments.assignment009.service.FileService;
import domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.jpassignments.assignment009.service.FileService.recipeReaderTest;

@RestController
public class FileController {

    //assigns key "object.name" located in application.properties to objectName;
    @Value("${object.name}")
    private String objectName;

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private FileService fileService;

    @GetMapping("/gluten-free")
    public Optional<List<String>> glutenFreeRecipes() throws IOException {
        return glutenFreeRecipes();
    }

    @GetMapping("/vegan")
    public List<String> veganRecipes() throws IOException {
        return null;
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<String> veganAndGlutenFreeRecipes() throws IOException {
        return null;
    }

    @GetMapping("/vegetarian")
    public List<String> vegetarianRecipes() throws IOException {
        return null;
    }

    @GetMapping("/all-recipes")
    public List<String> allRecipes() throws IOException {
        return null;
    }



//    @GetMapping("/")
//    public List<Recipe> readLines() throws IOException {
//        System.out.println("################################");
//        FileService fileService = applicationContext.getBean(FileService.class);
//        System.out.println(fileService);
//        fileService = applicationContext.getBean(FileService.class);
//        System.out.println(fileService);
//        fileService = applicationContext.getBean(FileService.class);
//        System.out.println(fileService);
//
//        return fileService.parseFileAndReturnRecipeList("src/main/resources/recipes.txt");
//    }

    @GetMapping("/")
    public List<Recipe> readLines() throws IOException {
        recipeReaderTest();
        return null;
    }

}

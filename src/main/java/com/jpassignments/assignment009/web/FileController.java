package com.jpassignments.assignment009.web;

import com.jpassignments.assignment009.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FileController {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private FileService fileService;

    @GetMapping("/gluten-free")
    public List<String> glutenFreeRecipes() throws IOException {
        return null;
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



    @GetMapping("")
    public List<String> readLines() throws IOException {
        System.out.println("################################");
        FileService fileService = applicationContext.getBean(FileService.class);
        System.out.println(fileService);
        fileService = applicationContext.getBean(FileService.class);
        System.out.println(fileService);
        fileService = applicationContext.getBean(FileService.class);
        System.out.println(fileService);

        return fileService.readFile("text.txt");
    }
}

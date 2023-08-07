package com.jpassignments.assignment009.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
//@Scope("prototype")
public class FileService {

    public List<String> readFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        return Files.readAllLines(filePath);
    }
}

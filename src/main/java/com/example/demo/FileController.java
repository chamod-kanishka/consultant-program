package com.example.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

//@CrossOrigin(origins = "http://localhost:8081")
@CrossOrigin(origins = "*")
@RestController
public class FileController {

    @PostMapping("/createFolderAndFile")
    public ResponseEntity<String> createFolderAndFile(@RequestBody FileRequest fileRequest) {
        // Get user inputs
        String name = fileRequest.getName();
        String topic = fileRequest.getTopic();
        String message = fileRequest.getMessage();

        // Create a folder for the user's name
        Path userFolder = Paths.get("C:/Users/ASUS/Desktop/auto-create/" + name);
        createFolder(userFolder);

        // Create a text file with the specified topic inside the user's folder
        Path textFilePath = userFolder.resolve(topic + ".txt");
        createTextFile(textFilePath);

        // Append the message to the text file
        appendMessage(textFilePath, message);

        return ResponseEntity.ok("Folder, file, and messages created successfully!");
    }

    private static void createFolder(Path userFolder) {
        try {
            Files.createDirectories(userFolder);
        } catch (FileAlreadyExistsException e) {
            // Folder already exists, no need to handle this case
        } catch (Exception e) {
            throw new RuntimeException("Error creating folder: " + e.getMessage(), e);
        }
    }

    private static void createTextFile(Path textFilePath) {
        try {
            // Check if the file already exists
            if (!Files.exists(textFilePath)) {
                // Create the file
                Files.createFile(textFilePath);
            }
        } catch (FileAlreadyExistsException e) {
            // File already exists, no need to handle this case
        } catch (Exception e) {
            throw new RuntimeException("Error creating text file: " + e.getMessage(), e);
        }
    }

    private static void appendMessage(Path textFilePath, String message) {
        try {
            // Open the existing text file for appending
            try (BufferedWriter writer = Files.newBufferedWriter(textFilePath, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
                // Write the additional input (message) to the text file
                writer.write(message);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error appending message to the text file: " + e.getMessage(), e);
        }
    }
}

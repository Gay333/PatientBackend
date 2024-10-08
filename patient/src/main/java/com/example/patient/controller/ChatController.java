package com.example.patient.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/chatbot")
public class ChatController {

    @PostMapping(value = "/query", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getResponse(@RequestBody String userInput) {
        String response = callPythonScript(userInput);
        return ResponseEntity.ok(response);
    }

    private String callPythonScript(String userInput) {
        StringBuilder output = new StringBuilder();
        System.out.println("Received user input: " + userInput);
        try {
            // Command to execute the Python script
            String[] command = new String[]{"python", "C:/Users/Gayathri.Venkatesan/Downloads/myscript.py", userInput};
            System.out.println("Executing command: " + String.join(" ", command));

            // Start the process
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();

            // Read the output from the Python script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Python script exited with code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while calling Python script.";
        }
        System.out.println("Python script output: " + output.toString());
        return output.toString();
    }

}

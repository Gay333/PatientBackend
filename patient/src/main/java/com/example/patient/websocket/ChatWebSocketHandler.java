package com.example.patient.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatWebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String userInput = message.getPayload();
        String response = callPythonScript(userInput);
        session.sendMessage(new TextMessage(response));
    }

    private String callPythonScript(String userInput) {
        StringBuilder output = new StringBuilder();
        //System.out.println("Received user input: " + userInput);
        try {
            // Command to execute the Python script
            String[] command = new String[]{"python", "C:/Users/Gayathri.Venkatesan/Downloads/myscript.py", userInput};
            //System.out.println("Executing command: " + String.join(" ", command));

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
            //System.out.println("Python script exited with code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while calling Python script.";
        }
        //System.out.println("Python script output: " + output.toString());
        return output.toString();
    }
}


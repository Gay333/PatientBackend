package com.example.patient.model;
public class ChatModel {
    private String prompt;
    private Integer maxTokens;
    // Getters and setters for prompt and maxTokens
    public String getPrompt() {
        return prompt;
    }
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    public Integer getMaxTokens() {
        return maxTokens;
    }
    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }
}
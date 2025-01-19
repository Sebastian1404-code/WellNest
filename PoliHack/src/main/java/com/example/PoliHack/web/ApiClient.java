package com.example.PoliHack.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

public class ApiClient {

    private final WebClient webClient;

    public ApiClient() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8787")
                .build();
    }


    public Mono<String> sendQuestion(String question) {
        question=sanitizeInput(question);
        return webClient.post()
                .uri("/api/v1/ai/question")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"question\": \"" + question + "\"}")
                .retrieve()
                .bodyToMono(String.class) // Get the response as a Mono
                .map(response -> {
                    try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode outerJson = objectMapper.readTree(response);
                        String innerJsonString = outerJson.get("response").toString();
                        JsonNode innerJson = objectMapper.readTree(innerJsonString);
                        return objectMapper.readTree(innerJson.asText()).get("message").toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return "Error parsing response";
                    }
                });
    }
    private String sanitizeInput(String input) {
        // Remove control characters (ASCII 0-31) and delete character (ASCII 127)
        return input.replaceAll("[\\x00-\\x1F\\x7F]", "");
    }

}



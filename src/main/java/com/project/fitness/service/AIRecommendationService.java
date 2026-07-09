package com.project.fitness.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.fitness.ai.PromptBuilder;
import com.project.fitness.dto.RecommendationResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIRecommendationService {

    private final ChatClient chatClient;
    private final PromptBuilder promptBuilder;
    private final ObjectMapper objectMapper;

    public RecommendationResponse generateRecommendation(User user, Activity activity) {

        try {

            String prompt = promptBuilder.build(user, activity);

            String response = chatClient
                    .prompt(prompt)
                    .call()
                    .content();

            return objectMapper.readValue(response, RecommendationResponse.class);

        } catch (Exception e) {
            throw new RuntimeException("Failed to generate AI recommendation", e);
        }
    }
}

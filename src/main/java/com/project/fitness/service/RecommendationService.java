package com.project.fitness.service;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.dto.RecommendationResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.RecommendationRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;
    private final AIRecommendationService aiRecommendationService;

    public Recommendation generateRecommendation(RecommendationRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found: " + request.getUserId()));

        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(() ->
                        new RuntimeException("Activity not found: " + request.getActivityId()));

        RecommendationResponse aiResponse =
                aiRecommendationService.generateRecommendation(user, activity);

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .type("AI_GENERATED")
                .summary(aiResponse.getSummary())
                .improvements(aiResponse.getImprovements())
                .suggestions(aiResponse.getSuggestions())
                .safety(aiResponse.getSafety())
                .build();

        return recommendationRepository.save(recommendation);
    }

    public List<Recommendation> getRecommendationsByUser(String userId) {
        return recommendationRepository.getByUserId(userId);
    }

    public List<Recommendation> getRecommendationsByActivity(String activityId) {
        return recommendationRepository.getByActivityId(activityId);
    }
}
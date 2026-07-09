package com.project.fitness.mapper;

import com.project.fitness.dto.RecommendationDto;
import com.project.fitness.model.Recommendation;
import org.springframework.stereotype.Component;

@Component
public class RecommendationMapper {

    public RecommendationDto toDto(Recommendation recommendation) {

        return RecommendationDto.builder()
                .id(recommendation.getId())
                .userId(recommendation.getUser().getId())
                .activityId(recommendation.getActivity().getId())
                .type(recommendation.getType())
                .summary(recommendation.getSummary())
                .improvements(recommendation.getImprovements())
                .suggestions(recommendation.getSuggestions())
                .safety(recommendation.getSafety())
                .createdAt(recommendation.getCreatedAt())
                .build();
    }
}
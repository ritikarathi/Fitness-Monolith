package com.project.fitness.controller;

import com.project.fitness.dto.RecommendationDto;
import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.mapper.RecommendationMapper;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;
    private final RecommendationMapper recommendationMapper;

    @PostMapping("/generate")
    public ResponseEntity<RecommendationDto> generateRecommendation(
            @RequestBody RecommendationRequest request) {

        Recommendation recommendation =
                recommendationService.generateRecommendation(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(recommendationMapper.toDto(recommendation));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecommendationDto>> getRecommendationsByUser(
            @PathVariable String userId) {

        List<RecommendationDto> recommendations =
                recommendationService.getRecommendationsByUser(userId)
                        .stream()
                        .map(recommendationMapper::toDto)
                        .toList();

        return ResponseEntity.ok(recommendations);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<RecommendationDto>> getRecommendationsByActivity(
            @PathVariable String activityId) {

        List<RecommendationDto> recommendations =
                recommendationService.getRecommendationsByActivity(activityId)
                        .stream()
                        .map(recommendationMapper::toDto)
                        .toList();

        return ResponseEntity.ok(recommendations);
    }
}
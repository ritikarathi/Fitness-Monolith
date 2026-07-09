package com.project.fitness.ai;

import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import org.springframework.stereotype.Component;

@Component
public class PromptBuilder {

    public String build(User user, Activity activity) {

        return String.format("""
You are an expert fitness coach and certified nutrition advisor.

Your task is to generate a personalized fitness recommendation.

User Details:
Name: %s %s
Age: %s
Height: %.1f cm
Weight: %.1f kg
Fitness Goal: %s

Today's Activity:
Activity Type: %s
Duration: %d minutes
Calories Burned: %d

Additional Metrics:
%s

Return ONLY valid JSON in exactly this format.

{
  "summary": "",
  "improvements": [],
  "suggestions": [],
  "safety": []
}

Rules:

- Do not use markdown.
- Do not explain anything.
- Do not wrap JSON inside ``` blocks.
- Give maximum 3 improvements.
- Give maximum 3 suggestions.
- Give maximum 3 safety tips.
- Summary should be under 40 words.

""",
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getHeight(),
                user.getWeight(),
                user.getFitnessGoal(),
                activity.getType(),
                activity.getDuration(),
                activity.getCaloriesBurned(),
                activity.getAdditionalMetrics()
        );

    }

}

package com.workout_planner_service.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    private UUID Id;
    private String Name;
    private ExerciseCategory Category;
    private ExerciseType Type;
    private User Owner;
    private LocalDateTime CreatedAt;
}

package com.workout_planner_service.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseCategory {
    private UUID Id;
    private String Name;
    private User Owner;
    private LocalDateTime CreatedAt;
}

package com.workout_planner_service.domain.model;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseType {
    private UUID Id;
    private String Name;
    private String WeightUnit;
    private String DistanceUnit;
}

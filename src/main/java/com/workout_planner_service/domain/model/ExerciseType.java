package com.workout_planner_service.domain.model;

import java.util.UUID;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseType {
  private UUID id;
  private String name;
  private String weightUnit;
  private String distanceUnit;
}

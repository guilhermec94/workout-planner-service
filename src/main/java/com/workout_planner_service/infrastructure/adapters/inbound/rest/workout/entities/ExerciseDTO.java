package com.workout_planner_service.infrastructure.adapters.inbound.rest.workout.entities;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExerciseDTO {
  private UUID id;
  private String name;
  private ExerciseCategoryDTO category;
  private ExerciseTypeDTO type;
}

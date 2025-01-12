package com.workout_planner_service.infrastructure.adapters.inbound.rest.workout.entities;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WorkoutDTO {

  private UUID id;
  private String name;
  private List<ExerciseDTO> exercises;
}

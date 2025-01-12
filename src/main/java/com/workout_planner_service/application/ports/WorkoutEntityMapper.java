package com.workout_planner_service.application.ports;

import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.domain.model.Workout;

public class WorkoutEntityMapper {

  public Workout toDomain(WorkoutDTO dto, User user) {
    return Workout.builder().name(dto.getName()).owner(user).build();
  }
}

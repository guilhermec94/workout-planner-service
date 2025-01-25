package com.workout_planner_service.application.ports;

import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.domain.model.Workout;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutDTO;

public class WorkoutEntityMapper {

  public Workout toDomain(WorkoutDTO dto, User user) {
    return Workout.builder().name(dto.getName()).owner(user).build();
  }

  public WorkoutDTO toDTO(Workout entity) {
    return WorkoutDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .creationDate(String.valueOf(entity.getCreatedAt()))
        .build();
  }
}

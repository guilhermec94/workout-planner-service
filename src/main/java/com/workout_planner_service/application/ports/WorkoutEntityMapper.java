package com.workout_planner_service.application.ports;

import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.domain.model.Workout;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutDTO;
import java.time.OffsetDateTime;
import java.util.Objects;
import org.mapstruct.ap.internal.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class WorkoutEntityMapper {

  public Workout toDomain(WorkoutDTO dto, User user) {
    return Workout.builder()
        .name(dto.getName())
        .owner(user)
        .createdAt(
            Strings.isEmpty(String.valueOf(dto.getCreatedAt()))
                ? OffsetDateTime.now()
                : Objects.requireNonNull(dto.getCreatedAt()))
        .build();
  }

  public WorkoutDTO toDTO(Workout entity) {
    return WorkoutDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .createdAt(OffsetDateTime.from(entity.getCreatedAt()))
        .build();
  }
}

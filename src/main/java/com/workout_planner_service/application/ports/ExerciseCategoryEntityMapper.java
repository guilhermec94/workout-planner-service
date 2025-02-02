package com.workout_planner_service.application.ports;

import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseCategoryDTO;
import java.time.OffsetDateTime;
import java.util.Objects;
import org.mapstruct.ap.internal.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class ExerciseCategoryEntityMapper {

  public ExerciseCategory toDomain(ExerciseCategoryDTO dto, User user) {
    return ExerciseCategory.builder()
        .name(dto.getName())
        .owner(user)
        .createdAt(
            Strings.isEmpty(String.valueOf(dto.getCreatedAt()))
                ? OffsetDateTime.now()
                : Objects.requireNonNull(dto.getCreatedAt()))
        .build();
  }

  public ExerciseCategoryDTO toDTO(ExerciseCategory entity) {
    return ExerciseCategoryDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .createdAt(OffsetDateTime.from(entity.getCreatedAt()))
        .build();
  }
}

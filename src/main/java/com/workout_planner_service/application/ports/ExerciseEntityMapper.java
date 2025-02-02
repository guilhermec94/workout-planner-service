package com.workout_planner_service.application.ports;

import com.workout_planner_service.application.exceptions.ExerciseCategoryNotFoundException;
import com.workout_planner_service.application.ports.outbound.persistence.ExerciseCategoryPersistencePort;
import com.workout_planner_service.domain.model.Exercise;
import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
import java.time.OffsetDateTime;
import java.util.Objects;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.mapstruct.ap.internal.util.Strings;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExerciseEntityMapper {

  private final ExerciseCategoryPersistencePort persistencePort;

  public Exercise toDomain(@NonNull ExerciseDTO dto, @NonNull User user) {
    var category = persistencePort.getExerciseCategoryById(dto.getCategoryId());
    if (category.isEmpty()) {
      throw new ExerciseCategoryNotFoundException(
          "Category with ID " + dto.getCategoryId() + " not found");
    }
    return Exercise.builder()
        .name(dto.getName())
        .category(category.get())
        .owner(user)
        .createdAt(
            Strings.isEmpty(String.valueOf(dto.getCreatedAt()))
                ? OffsetDateTime.now()
                : Objects.requireNonNull(dto.getCreatedAt()))
        .build();
  }

  public ExerciseDTO toDTO(@NonNull Exercise entity) {
    return ExerciseDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .categoryId(entity.getCategory().getId())
        .createdAt(OffsetDateTime.from(entity.getCreatedAt()))
        .build();
  }
}

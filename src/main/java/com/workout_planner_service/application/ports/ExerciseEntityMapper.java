package com.workout_planner_service.application.ports;

import com.workout_planner_service.application.exceptions.ExerciseCategoryNotFoundException;
import com.workout_planner_service.application.ports.outbound.persistence.ExerciseCategoryPersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.application.ports.security.CurrentUserProvider;
import com.workout_planner_service.domain.model.Exercise;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
import java.time.OffsetDateTime;
import java.util.Objects;
import lombok.NonNull;
import org.mapstruct.ap.internal.util.Strings;
import org.mapstruct.ap.shaded.freemarker.template.utility.NullArgumentException;
import org.springframework.stereotype.Component;

@Component
public class ExerciseEntityMapper implements BaseEntityMapper<ExerciseDTO, Exercise> {

  private final UserPersistencePort userPersistencePort;
  private final ExerciseCategoryPersistencePort exerciseCategoryPersistencePort;
  private final CurrentUserProvider currentUserProvider;

  public ExerciseEntityMapper(
      UserPersistencePort userPersistencePort,
      ExerciseCategoryPersistencePort exerciseCategoryPersistencePort,
      CurrentUserProvider currentUserProvider) {
    this.userPersistencePort = userPersistencePort;
    this.exerciseCategoryPersistencePort = exerciseCategoryPersistencePort;
    this.currentUserProvider = currentUserProvider;
  }

  @Override
  public Exercise toDomain(@NonNull ExerciseDTO dto) {
    var user = userPersistencePort.getById(currentUserProvider.getCurrentUser());
    if (user.isEmpty()) {
      throw new NullArgumentException("No owner received");
    }

    var category = exerciseCategoryPersistencePort.getById(dto.getCategoryId());
    if (category.isEmpty()) {
      throw new ExerciseCategoryNotFoundException(
          "Category with ID " + dto.getCategoryId() + " not found");
    }

    return Exercise.builder()
        .name(dto.getName())
        .category(category.get())
        .owner(user.get())
        .createdAt(
            Strings.isEmpty(String.valueOf(dto.getCreatedAt()))
                ? OffsetDateTime.now()
                : Objects.requireNonNull(dto.getCreatedAt()))
        .build();
  }

  @Override
  public ExerciseDTO toDTO(@NonNull Exercise entity) {
    return ExerciseDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .categoryId(entity.getCategory().getId())
        .createdAt(OffsetDateTime.from(entity.getCreatedAt()))
        .build();
  }
}

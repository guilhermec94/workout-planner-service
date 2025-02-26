package com.workout_planner_service.application.ports;

import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.application.ports.security.CurrentUserProvider;
import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseCategoryDTO;
import java.time.OffsetDateTime;
import java.util.Objects;
import lombok.NonNull;
import org.mapstruct.ap.internal.util.Strings;
import org.mapstruct.ap.shaded.freemarker.template.utility.NullArgumentException;
import org.springframework.stereotype.Component;

@Component
public class ExerciseCategoryEntityMapper
    implements BaseEntityMapper<ExerciseCategoryDTO, ExerciseCategory> {

  private final UserPersistencePort userPersistencePort;
  private final CurrentUserProvider currentUserProvider;

  public ExerciseCategoryEntityMapper(
      UserPersistencePort userPersistencePort, CurrentUserProvider currentUserProvider) {
    this.userPersistencePort = userPersistencePort;
    this.currentUserProvider = currentUserProvider;
  }

  @Override
  public ExerciseCategory toDomain(@NonNull ExerciseCategoryDTO dto) {

    var user = userPersistencePort.getById(currentUserProvider.getCurrentUser());
    if (user.isEmpty()) {
      throw new NullArgumentException("No owner received");
    }

    return ExerciseCategory.builder()
        .name(dto.getName())
        .owner(user.get())
        .createdAt(
            Strings.isEmpty(String.valueOf(dto.getCreatedAt()))
                ? OffsetDateTime.now()
                : Objects.requireNonNull(dto.getCreatedAt()))
        .build();
  }

  @Override
  public ExerciseCategoryDTO toDTO(@NonNull ExerciseCategory entity) {
    return ExerciseCategoryDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .createdAt(OffsetDateTime.from(entity.getCreatedAt()))
        .build();
  }
}

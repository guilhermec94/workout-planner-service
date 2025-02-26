package com.workout_planner_service.application.ports;

import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.application.ports.security.CurrentUserProvider;
import com.workout_planner_service.domain.model.Workout;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutDTO;
import java.time.OffsetDateTime;
import java.util.Objects;
import lombok.NonNull;
import org.mapstruct.ap.internal.util.Strings;
import org.mapstruct.ap.shaded.freemarker.template.utility.NullArgumentException;
import org.springframework.stereotype.Component;

@Component
public class WorkoutEntityMapper implements BaseEntityMapper<WorkoutDTO, Workout> {

  private final UserPersistencePort userPersistencePort;
  private final CurrentUserProvider currentUserProvider;

  public WorkoutEntityMapper(
      UserPersistencePort userPersistencePort, CurrentUserProvider currentUserProvider) {
    this.userPersistencePort = userPersistencePort;
    this.currentUserProvider = currentUserProvider;
  }

  @Override
  public Workout toDomain(@NonNull WorkoutDTO dto) {
    var user = userPersistencePort.getById(currentUserProvider.getCurrentUser());
    if (user.isEmpty()) {
      throw new NullArgumentException("No owner received");
    }

    return Workout.builder()
        .name(dto.getName())
        .owner(user.get())
        .createdAt(
            Strings.isEmpty(String.valueOf(dto.getCreatedAt()))
                ? OffsetDateTime.now()
                : Objects.requireNonNull(dto.getCreatedAt()))
        .build();
  }

  public WorkoutDTO toDTO(@NonNull Workout entity) {
    return WorkoutDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .createdAt(OffsetDateTime.from(entity.getCreatedAt()))
        .build();
  }
}

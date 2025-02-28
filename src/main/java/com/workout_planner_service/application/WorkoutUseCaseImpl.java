package com.workout_planner_service.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.workout_planner_service.application.exceptions.UserNotFoundException;
import com.workout_planner_service.application.ports.WorkoutEntityMapper;
import com.workout_planner_service.application.ports.inbound.WorkoutUseCase;
import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.WorkoutPersistencePort;
import com.workout_planner_service.domain.model.Workout;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutDTO;
import java.util.List;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class WorkoutUseCaseImpl extends BaseUseCaseImpl<WorkoutDTO, Workout>
    implements WorkoutUseCase {

  // 2e97b683-1b68-406d-b101-533c347e67ea implement port and fetch user
  private final UserPersistencePort userPersistencePort;
  private final WorkoutEntityMapper mapper;
  private final WorkoutPersistencePort persistencePort;

  public WorkoutUseCaseImpl(
      WorkoutPersistencePort persistencePort,
      UserPersistencePort userPersistencePort,
      WorkoutEntityMapper mapper,
      ObjectMapper objectMapper) {
    super(persistencePort, mapper, objectMapper, Workout.class);
    this.persistencePort = persistencePort;
    this.userPersistencePort = userPersistencePort;
    this.mapper = mapper;
  }

  @Override
  public List<WorkoutDTO> getAllWorkouts(@NonNull UUID userId) {
    return this.persistencePort.getAll(userId).stream().map(mapper::toDTO).toList();
  }

  @Override
  public WorkoutDTO createWorkout(@NonNull WorkoutDTO dto, @NonNull UUID userId) {
    var user = userPersistencePort.getById(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    return this.create(dto);
  }

  @Override
  public void patchWorkout(@NonNull JsonPatch patch, @NonNull UUID id, @NonNull UUID userId)
      throws JsonPatchException, JsonProcessingException {
    var user = this.userPersistencePort.getById(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    this.patch(patch, id);
  }
}

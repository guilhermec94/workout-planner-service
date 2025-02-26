package com.workout_planner_service.application;

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
      WorkoutEntityMapper mapper) {
    super(persistencePort, mapper);
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
  public void patchWorkout(@NonNull WorkoutDTO dto, @NonNull UUID id, @NonNull UUID userId) {
    var user = this.userPersistencePort.getById(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    /*var entity = this.workoutPersistencePort.getWorkoutById(id);
    if (entity.isEmpty()) {
      throw new WorkoutNotFoundException("Workout with ID " + id + " not found");
    }

    entity.get().setName(workout.getName());*/
    this.patch(dto, id);
  }
}

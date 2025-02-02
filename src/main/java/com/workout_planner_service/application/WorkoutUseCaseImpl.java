package com.workout_planner_service.application;

import com.workout_planner_service.application.exceptions.UserNotFoundException;
import com.workout_planner_service.application.exceptions.WorkoutNotFoundException;
import com.workout_planner_service.application.ports.WorkoutEntityMapper;
import com.workout_planner_service.application.ports.inbound.WorkoutUseCase;
import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.WorkoutPersistencePort;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WorkoutUseCaseImpl implements WorkoutUseCase {

  // 2e97b683-1b68-406d-b101-533c347e67ea implement port and fetch user
  private final UserPersistencePort userPersistencePort;
  private final WorkoutPersistencePort workoutPersistencePort;
  private final WorkoutEntityMapper mapper;

  @Override
  public List<WorkoutDTO> getAllWorkouts(@NonNull UUID userId) {
    return this.workoutPersistencePort.getAllWorkouts(userId).stream().map(mapper::toDTO).toList();
  }

  @Override
  public Optional<WorkoutDTO> getWorkoutById(@NonNull UUID id) {
    return this.workoutPersistencePort.getWorkoutById(id).map(mapper::toDTO);
  }

  @Override
  public WorkoutDTO createWorkout(@NonNull WorkoutDTO workout, @NonNull UUID userId) {
    var user = userPersistencePort.GetByID(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    var entity = mapper.toDomain(workout, user.get());
    return mapper.toDTO(this.workoutPersistencePort.saveWorkout(entity));
  }

  // TODO: implement jsonpatch
  @Override
  public void patchWorkout(@NonNull WorkoutDTO workout, @NonNull UUID id, @NonNull UUID userId) {
    var user = userPersistencePort.GetByID(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    var entity = this.workoutPersistencePort.getWorkoutById(id);
    if (entity.isEmpty()) {
      throw new WorkoutNotFoundException("Workout with ID " + id + " not found");
    }

    entity.get().setName(workout.getName());
    this.workoutPersistencePort.saveWorkout(entity.get());
  }

  @Override
  public void deleteWorkout(@NonNull UUID id) {
    this.workoutPersistencePort.deleteWorkout(id);
  }
}

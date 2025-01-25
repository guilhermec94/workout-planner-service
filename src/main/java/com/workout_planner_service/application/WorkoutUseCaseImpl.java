package com.workout_planner_service.application;

import com.workout_planner_service.application.ports.WorkoutEntityMapper;
import com.workout_planner_service.application.ports.inbound.WorkoutUseCase;
import com.workout_planner_service.application.ports.outbound.UserPersistencePort;
import com.workout_planner_service.application.ports.outbound.WorkoutPersistencePort;
import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.domain.model.Workout;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
  public List<WorkoutDTO> getAllWorkouts(UUID userId) {
    return this.workoutPersistencePort.getAllWorkouts(userId).stream().map(mapper::toDTO).toList();
  }

  @Override
  public Optional<WorkoutDTO> getWorkoutById(UUID id) {
    return Optional.ofNullable(mapper.toDTO(this.workoutPersistencePort.getWorkoutById(id).get()));
  }

  @Override
  public Workout createWorkout(WorkoutDTO workout, UUID userId) {
    var user = userPersistencePort.GetByID(userId);
    if (user.isEmpty()) {

    }
    var entity = mapper.toDomain(workout, user.get());
    return this.workoutPersistencePort.saveWorkout(entity);
  }

  @Override
  public Workout patchWorkout(WorkoutDTO workout, UUID userId) {
    var user = userPersistencePort.GetByID(userId);
    if (user.isEmpty()) {

    }
    var entity = mapper.toDomain(workout, user.get());
    return this.workoutPersistencePort.saveWorkout(entity);
  }

  @Override
  public void deleteWorkout(UUID id) {
    this.workoutPersistencePort.deleteWorkout(id);
  }
}

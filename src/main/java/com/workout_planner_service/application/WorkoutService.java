package com.workout_planner_service.application;

import com.workout_planner_service.application.ports.inbound.WorkoutUseCase;
import com.workout_planner_service.application.ports.outbound.WorkoutPersistencePort;
import com.workout_planner_service.domain.model.Workout;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WorkoutService implements WorkoutUseCase {

  private final WorkoutPersistencePort workoutPersistencePort;

  @Override
  public List<Workout> getAllWorkouts(UUID userId) {
    return this.workoutPersistencePort.getAllWorkouts(userId);
  }

  @Override
  public Optional<Workout> getWorkoutById(UUID id) {
    return this.workoutPersistencePort.getWorkoutById(id);
  }

  @Override
  public Workout createWorkout(Workout workout) {
    return this.workoutPersistencePort.saveWorkout(workout);
  }

  @Override
  public Workout patchWorkout(Workout workout) {
    return this.workoutPersistencePort.saveWorkout(workout);
  }

  @Override
  public void deleteWorkout(UUID id) {
    this.workoutPersistencePort.deleteWorkout(id);
  }
}

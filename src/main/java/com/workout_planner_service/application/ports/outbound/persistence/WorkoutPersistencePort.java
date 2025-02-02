package com.workout_planner_service.application.ports.outbound.persistence;

import com.workout_planner_service.domain.model.Workout;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;

public interface WorkoutPersistencePort {

  List<Workout> getAllWorkouts(@NonNull UUID userId);

  Optional<Workout> getWorkoutById(@NonNull UUID id);

  Workout saveWorkout(@NonNull Workout workout);

  void deleteWorkout(@NonNull UUID id);
}

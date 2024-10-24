package com.workout_planner_service.application.ports.outbound;

import com.workout_planner_service.domain.model.Workout;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkoutPersistencePort {

  List<Workout> getAllWorkouts(UUID userId);

  Optional<Workout> getWorkoutById(UUID id);

  Workout saveWorkout(Workout workout);

  Workout patchWorkout(Workout workout);

  void deleteWorkout(UUID id);
}

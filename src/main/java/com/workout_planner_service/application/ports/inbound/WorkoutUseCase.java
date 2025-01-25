package com.workout_planner_service.application.ports.inbound;

import com.workout_planner_service.domain.model.Workout;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkoutUseCase {

  List<WorkoutDTO> getAllWorkouts(UUID userId);

  Optional<WorkoutDTO> getWorkoutById(UUID id);

  Workout createWorkout(WorkoutDTO workout, UUID userId);

  Workout patchWorkout(WorkoutDTO workout, UUID userId);

  void deleteWorkout(UUID id);
}

package com.workout_planner_service.application.ports.inbound;

import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;

public interface WorkoutUseCase {

  List<WorkoutDTO> getAllWorkouts(@NonNull UUID userId);

  Optional<WorkoutDTO> getWorkoutById(@NonNull UUID id);

  WorkoutDTO createWorkout(@NonNull WorkoutDTO workout, @NonNull UUID userId);

  void patchWorkout(@NonNull WorkoutDTO workout, @NonNull UUID id, @NonNull UUID userId);

  void deleteWorkout(@NonNull UUID id);
}

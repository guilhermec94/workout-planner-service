package com.workout_planner_service.application.ports.inbound;

import com.workout_planner_service.domain.model.Exercise;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseUseCase {

  List<Exercise> getAllExercises(UUID userId);

  Optional<Exercise> getExerciseById(UUID id);

  Exercise createExercise(Exercise exercise);

  Exercise patchExercise(Exercise exercise);

  void deleteExercise(UUID id);
}

package com.workout_planner_service.application.ports.inbound;

import com.workout_planner_service.domain.model.Exercise;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseUseCase {

  List<ExerciseDTO> getAllExercises(UUID userId);

  Optional<ExerciseDTO> getExerciseById(UUID id);

  ExerciseDTO createExercise(Exercise exercise);

  void patchExercise(Exercise exercise);

  void deleteExercise(UUID id);
}

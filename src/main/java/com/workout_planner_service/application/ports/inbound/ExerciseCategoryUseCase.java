package com.workout_planner_service.application.ports.inbound;

import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseCategoryDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;

public interface ExerciseCategoryUseCase {

  List<ExerciseCategoryDTO> getAllExerciseCategories(@NonNull UUID userId);

  Optional<ExerciseCategoryDTO> getExerciseCategoryById(@NonNull UUID id);

  ExerciseCategoryDTO createExerciseCategory(
      @NonNull ExerciseCategoryDTO dto, @NonNull UUID userId);

  void patchExerciseCategory(
      @NonNull ExerciseCategoryDTO dto, @NonNull UUID id, @NonNull UUID userId);

  void deleteExerciseCategory(@NonNull UUID id);
}

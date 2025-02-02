package com.workout_planner_service.application.ports.inbound;

import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.CategoryDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseCategoryUseCase {

  List<CategoryDTO> getAllExerciseCategories(UUID userId);

  Optional<CategoryDTO> getExerciseCategoryById(UUID id);

  CategoryDTO createExerciseCategory(ExerciseCategory category);

  void patchExerciseCategory(ExerciseCategory category);

  void deleteExerciseCategory(UUID id);
}

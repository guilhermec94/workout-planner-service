package com.workout_planner_service.application.ports.outbound;

import com.workout_planner_service.domain.model.ExerciseCategory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseCategoryPersistencePort {

  List<ExerciseCategory> getAllExerciseCategories(UUID userId);

  Optional<ExerciseCategory> getExerciseCategoryById(UUID id);

  ExerciseCategory saveExerciseCategory(ExerciseCategory category);

  ExerciseCategory patchExerciseCategory(ExerciseCategory category);

  void deleteExerciseCategory(UUID id);
}

package com.workout_planner_service.application.ports.inbound;

import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.domain.model.Workout;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseCategoryUseCase {

  List<ExerciseCategory> getAllExerciseCategories(UUID userId);
  Optional<ExerciseCategory> getExerciseCategoryById(UUID id);
  ExerciseCategory createExerciseCategory(ExerciseCategory category);
  ExerciseCategory patchExerciseCategory(ExerciseCategory category);
  void deleteExerciseCategory(UUID id);
}

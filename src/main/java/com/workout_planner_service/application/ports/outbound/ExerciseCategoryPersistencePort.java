package com.workout_planner_service.application.ports.outbound;

import com.workout_planner_service.domain.model.ExerciseCategory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;

public interface ExerciseCategoryPersistencePort {

  List<ExerciseCategory> getAllExerciseCategories(@NonNull UUID userId);

  Optional<ExerciseCategory> getExerciseCategoryById(@NonNull UUID id);

  ExerciseCategory saveExerciseCategory(@NonNull ExerciseCategory category);

  void deleteExerciseCategory(@NonNull UUID id);
}

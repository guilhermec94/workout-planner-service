package com.workout_planner_service.application.ports.outbound.persistence;

import com.workout_planner_service.domain.model.ExerciseCategory;
import java.util.List;
import java.util.UUID;
import lombok.NonNull;

public interface ExerciseCategoryPersistencePort extends BasePersistencePort<ExerciseCategory> {

  List<ExerciseCategory> getAll(@NonNull UUID userId);
}

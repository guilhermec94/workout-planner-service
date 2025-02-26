package com.workout_planner_service.application.ports.outbound.persistence;

import com.workout_planner_service.domain.model.Exercise;
import java.util.List;
import java.util.UUID;
import lombok.NonNull;

public interface ExercisePersistencePort extends BasePersistencePort<Exercise> {

  List<Exercise> getAll(@NonNull UUID userId);
}

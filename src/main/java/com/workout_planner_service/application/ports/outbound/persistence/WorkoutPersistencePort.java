package com.workout_planner_service.application.ports.outbound.persistence;

import com.workout_planner_service.domain.model.Workout;
import java.util.List;
import java.util.UUID;
import lombok.NonNull;

public interface WorkoutPersistencePort extends BasePersistencePort<Workout> {
  List<Workout> getAll(@NonNull UUID userId);
}

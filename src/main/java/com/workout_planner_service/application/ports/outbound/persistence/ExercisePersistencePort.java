package com.workout_planner_service.application.ports.outbound.persistence;

import com.workout_planner_service.domain.model.Exercise;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;

public interface ExercisePersistencePort {

  List<Exercise> getAllExercises(@NonNull UUID userId);

  Optional<Exercise> getExerciseById(@NonNull UUID id);

  Exercise saveExercise(@NonNull Exercise exercise);

  void deleteExercise(@NonNull UUID id);
}

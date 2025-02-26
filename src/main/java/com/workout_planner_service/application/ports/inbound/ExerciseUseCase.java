package com.workout_planner_service.application.ports.inbound;

import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
import java.util.List;
import java.util.UUID;
import lombok.NonNull;

public interface ExerciseUseCase extends BaseUseCase<ExerciseDTO> {

  List<ExerciseDTO> getAllExercises(@NonNull UUID userId);

  ExerciseDTO createExercise(@NonNull ExerciseDTO dto, @NonNull UUID userId);

  void patchExercise(@NonNull ExerciseDTO dto, @NonNull UUID id, @NonNull UUID userId);
}

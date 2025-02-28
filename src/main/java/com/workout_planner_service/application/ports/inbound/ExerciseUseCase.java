package com.workout_planner_service.application.ports.inbound;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import lombok.NonNull;

public interface ExerciseUseCase extends BaseUseCase<ExerciseDTO> {

  List<ExerciseDTO> getAllExercises(@NonNull UUID userId);

  ExerciseDTO createExercise(@NonNull ExerciseDTO dto, @NonNull UUID userId);

  void patchExercise(@NonNull JsonPatch patch, @NonNull UUID id, @NonNull UUID userId)
      throws JsonPatchException, IOException;
}

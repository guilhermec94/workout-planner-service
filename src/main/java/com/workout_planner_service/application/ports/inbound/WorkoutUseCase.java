package com.workout_planner_service.application.ports.inbound;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutDTO;
import java.util.List;
import java.util.UUID;
import lombok.NonNull;

public interface WorkoutUseCase extends BaseUseCase<WorkoutDTO> {
  List<WorkoutDTO> getAllWorkouts(@NonNull UUID userId);

  WorkoutDTO createWorkout(@NonNull WorkoutDTO dto, @NonNull UUID userId);

  void patchWorkout(@NonNull JsonPatch patch, @NonNull UUID id, @NonNull UUID userId)
      throws JsonPatchException, JsonProcessingException;
}

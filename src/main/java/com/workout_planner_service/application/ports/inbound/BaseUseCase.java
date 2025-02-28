package com.workout_planner_service.application.ports.inbound;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;

public interface BaseUseCase<T> {
  // TODO: add parameters to be called in the concrete implementation
  List<T> getAll();

  Optional<T> getById(@NonNull UUID id);

  T create(@NonNull T dto);

  void patch(@NonNull JsonPatch patch, @NonNull UUID id)
      throws JsonPatchException, JsonProcessingException;

  void delete(@NonNull UUID id);
}

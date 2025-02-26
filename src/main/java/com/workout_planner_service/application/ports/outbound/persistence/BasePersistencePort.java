package com.workout_planner_service.application.ports.outbound.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;

public interface BasePersistencePort<T> {
  // TODO: add query criteria params
  List<T> getAll();

  Optional<T> getById(@NonNull UUID id);

  T save(@NonNull T entity);

  void delete(@NonNull UUID id);
}

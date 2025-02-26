package com.workout_planner_service.application.ports;

import lombok.NonNull;

public interface BaseEntityMapper<T, E> {
  E toDomain(@NonNull T dto);

  T toDTO(@NonNull E entity);
}

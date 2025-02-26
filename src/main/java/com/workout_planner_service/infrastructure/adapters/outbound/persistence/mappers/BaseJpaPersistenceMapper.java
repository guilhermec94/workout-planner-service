package com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers;

public interface BaseJpaPersistenceMapper<T, E> {

  E toJpaEntity(T model);

  T toModel(E entity);
}

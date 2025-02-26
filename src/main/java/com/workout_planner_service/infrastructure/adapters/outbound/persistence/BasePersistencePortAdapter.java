package com.workout_planner_service.infrastructure.adapters.outbound.persistence;

import com.workout_planner_service.application.ports.outbound.persistence.BasePersistencePort;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers.BaseJpaPersistenceMapper;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories.BaseJpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BasePersistencePortAdapter<T, E> implements BasePersistencePort<T> {
  private final BaseJpaRepository<E> jpaRepository;
  private final BaseJpaPersistenceMapper<T, E> jpaPersistenceMapper;

  @Override
  public List<T> getAll() {
    List<E> entityList = this.jpaRepository.findAll();
    return entityList.stream().map(jpaPersistenceMapper::toModel).collect(Collectors.toList());
  }

  @Override
  public Optional<T> getById(@NonNull UUID id) {
    Optional<E> entity = this.jpaRepository.findById(id);
    return entity.map(this.jpaPersistenceMapper::toModel);
  }

  @Override
  public T save(@NonNull T model) {
    E entity = this.jpaPersistenceMapper.toJpaEntity(model);
    this.jpaRepository.save(entity);
    return this.jpaPersistenceMapper.toModel(entity);
  }

  @Override
  public void delete(@NonNull UUID id) {
    this.jpaRepository.deleteById(id);
  }
}

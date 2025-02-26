package com.workout_planner_service.application;

import com.workout_planner_service.application.exceptions.WorkoutNotFoundException;
import com.workout_planner_service.application.ports.BaseEntityMapper;
import com.workout_planner_service.application.ports.inbound.BaseUseCase;
import com.workout_planner_service.application.ports.outbound.persistence.BasePersistencePort;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseUseCaseImpl<T, E> implements BaseUseCase<T> {
  private final BasePersistencePort<E> persistencePort;
  private final BaseEntityMapper<T, E> mapper;

  @Override
  public List<T> getAll() {
    return this.persistencePort.getAll().stream().map(mapper::toDTO).toList();
  }

  @Override
  public Optional<T> getById(@NonNull UUID id) {
    return this.persistencePort.getById(id).map(mapper::toDTO);
  }

  @Override
  public T create(@NonNull T dto) {
    var entity = mapper.toDomain(dto);
    return mapper.toDTO(this.persistencePort.save(entity));
  }

  // TODO: implement jsonpatch
  @Override
  public void patch(@NonNull T dto, @NonNull UUID id) {
    var entity = this.persistencePort.getById(id);
    if (entity.isEmpty()) { // TODO: how to set the Class name here instead of entity?
      throw new WorkoutNotFoundException("Entity with ID " + id + " not found");
    }

    this.persistencePort.save(entity.get());
  }

  @Override
  public void delete(@NonNull UUID id) {
    this.persistencePort.delete(id);
  }
}

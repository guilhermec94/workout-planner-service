package com.workout_planner_service.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.workout_planner_service.application.exceptions.EntityNotFoundException;
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
  private final ObjectMapper objectMapper;
  private final Class<E> entityClass;

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

  @Override
  public void patch(@NonNull JsonPatch patch, @NonNull UUID id)
      throws JsonPatchException, JsonProcessingException {
    var entityOptional = this.persistencePort.getById(id);
    if (entityOptional.isEmpty()) { // TODO: how to set the Class name here instead of entity?
      throw new EntityNotFoundException("Entity with ID " + id + " not found");
    }

    E entity = entityOptional.get();
    JsonNode node = objectMapper.convertValue(entity, JsonNode.class);
    JsonNode patchedNode = patch.apply(node);
    E patchedEntity = objectMapper.treeToValue(patchedNode, entityClass);

    this.persistencePort.save(patchedEntity);
  }

  @Override
  public void delete(@NonNull UUID id) {
    this.persistencePort.delete(id);
  }
}

package com.workout_planner_service.application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.workout_planner_service.application.exceptions.ExerciseCategoryNotFoundException;
import com.workout_planner_service.application.exceptions.UserNotFoundException;
import com.workout_planner_service.application.ports.ExerciseEntityMapper;
import com.workout_planner_service.application.ports.inbound.ExerciseUseCase;
import com.workout_planner_service.application.ports.outbound.persistence.ExerciseCategoryPersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.ExercisePersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.domain.model.Exercise;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ExerciseUseCaseImpl extends BaseUseCaseImpl<ExerciseDTO, Exercise>
    implements ExerciseUseCase {
  private final UserPersistencePort userPersistencePort;
  private final ExerciseCategoryPersistencePort exerciseCategoryPersistencePort;
  private final ExerciseEntityMapper mapper;
  private final ExercisePersistencePort persistencePort;
  private final ObjectMapper objectMapper;

  public ExerciseUseCaseImpl(
      ExercisePersistencePort persistencePort,
      ExerciseEntityMapper mapper,
      UserPersistencePort userPersistencePort,
      ExerciseCategoryPersistencePort exerciseCategoryPersistencePort,
      ObjectMapper objectMapper) {
    super(persistencePort, mapper, objectMapper, Exercise.class);
    this.userPersistencePort = userPersistencePort;
    this.exerciseCategoryPersistencePort = exerciseCategoryPersistencePort;
    this.mapper = mapper;
    this.persistencePort = persistencePort;
    this.objectMapper = objectMapper;
  }

  @Override
  public List<ExerciseDTO> getAllExercises(@NonNull UUID userId) {
    return this.persistencePort.getAll(userId).stream().map(mapper::toDTO).toList();
  }

  @Override
  public ExerciseDTO createExercise(@NonNull ExerciseDTO dto, @NonNull UUID userId) {
    var user = userPersistencePort.getById(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    var category = this.exerciseCategoryPersistencePort.getById(dto.getCategoryId());
    if (category.isEmpty()) {
      throw new ExerciseCategoryNotFoundException(
          "Category with ID " + dto.getCategoryId() + " not found");
    }

    return this.create(dto);
  }

  @Override
  public void patchExercise(@NonNull JsonPatch patch, @NonNull UUID id, @NonNull UUID userId)
      throws JsonPatchException, IOException {
    var user = userPersistencePort.getById(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    String categoryId = "";
    JsonNode patchNode = objectMapper.convertValue(patch, JsonNode.class);
    if (patchNode.isArray()) {
      for (JsonNode opNode : patchNode) {
        if (opNode.has("path") && "/categoryId".equals(opNode.get("path").asText())) {
          categoryId = opNode.get("value").asText();
          ((ObjectNode) opNode).put("path", "/category/id");
        }
      }
    }

    var category = this.exerciseCategoryPersistencePort.getById(UUID.fromString(categoryId));
    if (category.isEmpty()) {
      throw new ExerciseCategoryNotFoundException(
          "Category with ID " + UUID.fromString(categoryId) + " not found");
    }

    patch = JsonPatch.fromJson(patchNode);
    this.patch(patch, id);
  }
}

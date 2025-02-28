package com.workout_planner_service.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.workout_planner_service.application.exceptions.UserNotFoundException;
import com.workout_planner_service.application.ports.ExerciseCategoryEntityMapper;
import com.workout_planner_service.application.ports.inbound.ExerciseCategoryUseCase;
import com.workout_planner_service.application.ports.outbound.persistence.ExerciseCategoryPersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseCategoryDTO;
import java.util.List;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ExerciseCategoryUseCaseImpl
    extends BaseUseCaseImpl<ExerciseCategoryDTO, ExerciseCategory>
    implements ExerciseCategoryUseCase {

  private final UserPersistencePort userPersistencePort;
  private final ExerciseCategoryEntityMapper mapper;
  private final ExerciseCategoryPersistencePort persistencePort;

  public ExerciseCategoryUseCaseImpl(
      UserPersistencePort userPersistencePort,
      ExerciseCategoryEntityMapper mapper,
      ExerciseCategoryPersistencePort persistencePort,
      ObjectMapper objectMapper) {
    super(persistencePort, mapper, objectMapper, ExerciseCategory.class);
    this.userPersistencePort = userPersistencePort;
    this.mapper = mapper;
    this.persistencePort = persistencePort;
  }

  @Override
  public List<ExerciseCategoryDTO> getAllExerciseCategories(@NonNull UUID userId) {
    return this.persistencePort.getAll(userId).stream().map(mapper::toDTO).toList();
  }

  @Override
  public ExerciseCategoryDTO createExerciseCategory(
      @NonNull ExerciseCategoryDTO dto, @NonNull UUID userId) {
    var user = userPersistencePort.getById(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    return this.create(dto);
  }

  @Override
  public void patchExerciseCategory(
      @NonNull JsonPatch patch, @NonNull UUID id, @NonNull UUID userId)
      throws JsonPatchException, JsonProcessingException {
    var user = userPersistencePort.getById(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    this.patch(patch, id);
  }
}

package com.workout_planner_service.application;

import com.workout_planner_service.application.exceptions.ExerciseCategoryNotFoundException;
import com.workout_planner_service.application.exceptions.UserNotFoundException;
import com.workout_planner_service.application.ports.ExerciseEntityMapper;
import com.workout_planner_service.application.ports.inbound.ExerciseUseCase;
import com.workout_planner_service.application.ports.outbound.persistence.ExerciseCategoryPersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.ExercisePersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.domain.model.Exercise;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
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

  public ExerciseUseCaseImpl(
      ExercisePersistencePort persistencePort,
      ExerciseEntityMapper mapper,
      UserPersistencePort userPersistencePort,
      ExerciseCategoryPersistencePort exerciseCategoryPersistencePort) {
    super(persistencePort, mapper);
    this.userPersistencePort = userPersistencePort;
    this.exerciseCategoryPersistencePort = exerciseCategoryPersistencePort;
    this.mapper = mapper;
    this.persistencePort = persistencePort;
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
  public void patchExercise(@NonNull ExerciseDTO dto, @NonNull UUID id, @NonNull UUID userId) {
    var user = userPersistencePort.getById(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    var category = this.exerciseCategoryPersistencePort.getById(dto.getCategoryId());
    if (category.isEmpty()) {
      throw new ExerciseCategoryNotFoundException(
          "Category with ID " + dto.getCategoryId() + " not found");
    }

    // TODO: implement correct patch logic
    /*entity.get().setName(dto.getName());
    entity.get().setCategory(category.get());*/
    this.patch(dto, id);
  }
}

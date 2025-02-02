package com.workout_planner_service.application;

import com.workout_planner_service.application.exceptions.ExerciseCategoryNotFoundException;
import com.workout_planner_service.application.exceptions.UserNotFoundException;
import com.workout_planner_service.application.ports.ExerciseEntityMapper;
import com.workout_planner_service.application.ports.inbound.ExerciseUseCase;
import com.workout_planner_service.application.ports.outbound.persistence.ExerciseCategoryPersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.ExercisePersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExerciseUseCaseImpl implements ExerciseUseCase {
  private final UserPersistencePort userPersistencePort;
  private final ExerciseCategoryPersistencePort exerciseCategoryPersistencePort;
  private final ExercisePersistencePort exercisePersistencePort;
  private final ExerciseEntityMapper mapper;

  @Override
  public List<ExerciseDTO> getAllExercises(@NonNull UUID userId) {
    return this.exercisePersistencePort.getAllExercises(userId).stream()
        .map(mapper::toDTO)
        .toList();
  }

  @Override
  public Optional<ExerciseDTO> getExerciseById(@NonNull UUID id) {
    return this.exercisePersistencePort.getExerciseById(id).map(mapper::toDTO);
  }

  @Override
  public ExerciseDTO createExercise(@NonNull ExerciseDTO dto, @NonNull UUID userId) {
    var user = userPersistencePort.GetByID(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    var category =
        this.exerciseCategoryPersistencePort.getExerciseCategoryById(dto.getCategoryId());
    if (category.isEmpty()) {
      throw new ExerciseCategoryNotFoundException(
          "Category with ID " + dto.getCategoryId() + " not found");
    }

    var entity = mapper.toDomain(dto, user.get());
    return mapper.toDTO(this.exercisePersistencePort.saveExercise(entity));
  }

  @Override
  public void patchExercise(@NonNull ExerciseDTO dto, @NonNull UUID id, @NonNull UUID userId) {
    var user = userPersistencePort.GetByID(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    var category =
        this.exerciseCategoryPersistencePort.getExerciseCategoryById(dto.getCategoryId());
    if (category.isEmpty()) {
      throw new ExerciseCategoryNotFoundException(
          "Category with ID " + dto.getCategoryId() + " not found");
    }

    var entity = this.exercisePersistencePort.getExerciseById(id);
    if (entity.isEmpty()) {
      throw new ExerciseCategoryNotFoundException("Exercise with ID " + id + " not found");
    }

    // TODO: implement correct patch logic
    entity.get().setName(dto.getName());
    entity.get().setCategory(category.get());
    this.exercisePersistencePort.saveExercise(entity.get());
  }

  @Override
  public void deleteExercise(@NonNull UUID id) {
    this.exercisePersistencePort.deleteExercise(id);
  }
}

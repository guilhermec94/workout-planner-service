package com.workout_planner_service.application;

import com.workout_planner_service.application.exceptions.ExerciseCategoryNotFoundException;
import com.workout_planner_service.application.exceptions.UserNotFoundException;
import com.workout_planner_service.application.ports.ExerciseCategoryMapper;
import com.workout_planner_service.application.ports.inbound.ExerciseCategoryUseCase;
import com.workout_planner_service.application.ports.outbound.persistence.ExerciseCategoryPersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseCategoryDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExerciseCategoryUseCaseImpl implements ExerciseCategoryUseCase {

  private final UserPersistencePort userPersistencePort;
  private final ExerciseCategoryPersistencePort exerciseCategoryPersistencePort;
  private final ExerciseCategoryMapper mapper;

  @Override
  public List<ExerciseCategoryDTO> getAllExerciseCategories(@NonNull UUID userId) {
    return this.exerciseCategoryPersistencePort.getAllExerciseCategories(userId).stream()
        .map(mapper::toDTO)
        .toList();
  }

  @Override
  public Optional<ExerciseCategoryDTO> getExerciseCategoryById(@NonNull UUID id) {
    return this.exerciseCategoryPersistencePort.getExerciseCategoryById(id).map(mapper::toDTO);
  }

  @Override
  public ExerciseCategoryDTO createExerciseCategory(
      @NonNull ExerciseCategoryDTO dto, @NonNull UUID userId) {
    var user = userPersistencePort.GetByID(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    var entity = mapper.toDomain(dto, user.get());
    return mapper.toDTO(this.exerciseCategoryPersistencePort.saveExerciseCategory(entity));
  }

  @Override
  public void patchExerciseCategory(
      @NonNull ExerciseCategoryDTO dto, @NonNull UUID id, @NonNull UUID userId) {
    var user = userPersistencePort.GetByID(userId);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    var entity = this.exerciseCategoryPersistencePort.getExerciseCategoryById(id);
    if (entity.isEmpty()) {
      throw new ExerciseCategoryNotFoundException("Category with ID " + id + " not found");
    }

    entity.get().setName(dto.getName());
    this.exerciseCategoryPersistencePort.saveExerciseCategory(entity.get());
  }

  @Override
  public void deleteExerciseCategory(@NonNull UUID id) {
    this.exerciseCategoryPersistencePort.deleteExerciseCategory(id);
  }
}

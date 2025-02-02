package com.workout_planner_service.infrastructure.adapters.outbound.persistence;

import com.workout_planner_service.application.ports.outbound.persistence.ExerciseCategoryPersistencePort;
import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers.ExerciseCategoryJpaPersistenceMapper;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories.ExerciseCategoryJpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseCategoryPersistenceAdapter implements ExerciseCategoryPersistencePort {

  private final ExerciseCategoryJpaRepository jpaRepository;
  private final ExerciseCategoryJpaPersistenceMapper jpaPersistenceMapper;

  @Override
  public List<ExerciseCategory> getAllExerciseCategories(@NonNull UUID userId) {
    var entityList = this.jpaRepository.getExerciseCategoriesByUserId(userId);
    return entityList.stream()
        .map(jpaPersistenceMapper::toExerciseCategory)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<ExerciseCategory> getExerciseCategoryById(@NonNull UUID id) {
    var entity = this.jpaRepository.findById(id);
    return entity.map(this.jpaPersistenceMapper::toExerciseCategory);
  }

  @Override
  public ExerciseCategory saveExerciseCategory(@NonNull ExerciseCategory category) {
    var entity = this.jpaPersistenceMapper.toExerciseCategoryJpaEntity(category);
    this.jpaRepository.save(entity);
    return this.jpaPersistenceMapper.toExerciseCategory(entity);
  }

  @Override
  public void deleteExerciseCategory(@NonNull UUID id) {
    this.jpaRepository.deleteById(id);
  }
}

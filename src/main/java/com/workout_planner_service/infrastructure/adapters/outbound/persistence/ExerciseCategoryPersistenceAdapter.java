package com.workout_planner_service.infrastructure.adapters.outbound.persistence;

import com.workout_planner_service.application.ports.outbound.persistence.ExerciseCategoryPersistencePort;
import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.ExerciseCategoryJpaEntity;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers.ExerciseCategoryJpaPersistenceMapper;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories.ExerciseCategoryJpaRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ExerciseCategoryPersistenceAdapter
    extends BasePersistencePortAdapter<ExerciseCategory, ExerciseCategoryJpaEntity>
    implements ExerciseCategoryPersistencePort {

  private final ExerciseCategoryJpaRepository jpaRepository;
  private final ExerciseCategoryJpaPersistenceMapper jpaPersistenceMapper;

  public ExerciseCategoryPersistenceAdapter(
      ExerciseCategoryJpaRepository jpaRepository,
      ExerciseCategoryJpaPersistenceMapper jpaPersistenceMapper) {
    super(jpaRepository, jpaPersistenceMapper);
    this.jpaRepository = jpaRepository;
    this.jpaPersistenceMapper = jpaPersistenceMapper;
  }

  @Override
  public List<ExerciseCategory> getAll(@NonNull UUID userId) {
    List<ExerciseCategoryJpaEntity> entityList =
        this.jpaRepository.getExerciseCategoriesByUserId(userId);
    return entityList.stream().map(jpaPersistenceMapper::toModel).collect(Collectors.toList());
  }
}

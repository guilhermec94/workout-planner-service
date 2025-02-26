package com.workout_planner_service.infrastructure.adapters.outbound.persistence;

import com.workout_planner_service.application.ports.outbound.persistence.ExercisePersistencePort;
import com.workout_planner_service.domain.model.Exercise;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.ExerciseJpaEntity;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers.ExerciseJpaPersistenceMapper;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories.ExerciseJpaRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ExercisePersistenceAdapter
    extends BasePersistencePortAdapter<Exercise, ExerciseJpaEntity>
    implements ExercisePersistencePort {

  private final ExerciseJpaRepository jpaRepository;
  private final ExerciseJpaPersistenceMapper jpaPersistenceMapper;

  public ExercisePersistenceAdapter(
      ExerciseJpaRepository jpaRepository, ExerciseJpaPersistenceMapper jpaPersistenceMapper) {
    super(jpaRepository, jpaPersistenceMapper);
    this.jpaRepository = jpaRepository;
    this.jpaPersistenceMapper = jpaPersistenceMapper;
  }

  @Override
  public List<Exercise> getAll(@NonNull UUID userId) {
    List<ExerciseJpaEntity> entityList = this.jpaRepository.getExercisesByUserId(userId);
    return entityList.stream().map(jpaPersistenceMapper::toModel).collect(Collectors.toList());
  }
}

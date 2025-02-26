package com.workout_planner_service.infrastructure.adapters.outbound.persistence;

import com.workout_planner_service.application.ports.outbound.persistence.WorkoutPersistencePort;
import com.workout_planner_service.domain.model.Workout;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.WorkoutJpaEntity;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers.WorkoutJpaPersistenceMapper;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories.WorkoutJpaRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class WorkoutPersistenceAdapter extends BasePersistencePortAdapter<Workout, WorkoutJpaEntity>
    implements WorkoutPersistencePort {

  private final WorkoutJpaRepository jpaRepository;
  private final WorkoutJpaPersistenceMapper jpaPersistenceMapper;

  public WorkoutPersistenceAdapter(
      WorkoutJpaRepository jpaRepository, WorkoutJpaPersistenceMapper jpaPersistenceMapper) {
    super(jpaRepository, jpaPersistenceMapper);
    this.jpaRepository = jpaRepository;
    this.jpaPersistenceMapper = jpaPersistenceMapper;
  }

  @Override
  public List<Workout> getAll(@NonNull UUID userId) {
    List<WorkoutJpaEntity> entityList = this.jpaRepository.getWorkoutsByUserId(userId);
    return entityList.stream().map(jpaPersistenceMapper::toModel).collect(Collectors.toList());
  }
}

package com.workout_planner_service.infrastructure.adapters.outbound.persistence;

import com.workout_planner_service.application.ports.outbound.WorkoutPersistencePort;
import com.workout_planner_service.domain.model.Workout;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers.WorkoutJpaPersistenceMapper;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories.WorkoutJpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutPersistenceAdapter implements WorkoutPersistencePort {

  private final WorkoutJpaRepository jpaRepository;
  private final WorkoutJpaPersistenceMapper jpaPersistenceMapper;

  @Override
  public List<Workout> getAllWorkouts(@NonNull UUID userId) {
    var entityList = this.jpaRepository.getWorkoutsByUserId(userId);
    return entityList.stream().map(jpaPersistenceMapper::toWorkout).collect(Collectors.toList());
  }

  @Override
  public Optional<Workout> getWorkoutById(@NonNull UUID id) {
    var entity = this.jpaRepository.findById(id);
    return entity.map(this.jpaPersistenceMapper::toWorkout);
  }

  @Override
  public Workout saveWorkout(@NonNull Workout workout) {
    var entity = this.jpaPersistenceMapper.toWorkoutJpaEntity(workout);
    this.jpaRepository.save(entity);
    return this.jpaPersistenceMapper.toWorkout(entity);
  }

  @Override
  public void deleteWorkout(@NonNull UUID id) {
    this.jpaRepository.deleteById(id);
  }
}

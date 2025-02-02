package com.workout_planner_service.infrastructure.adapters.outbound.persistence;

import com.workout_planner_service.application.ports.outbound.persistence.ExercisePersistencePort;
import com.workout_planner_service.domain.model.Exercise;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers.ExerciseJpaPersistenceMapper;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories.ExerciseJpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExercisePersistenceAdapter implements ExercisePersistencePort {

  private final ExerciseJpaRepository jpaRepository;
  private final ExerciseJpaPersistenceMapper jpaPersistenceMapper;

  @Override
  public List<Exercise> getAllExercises(@NonNull UUID userId) {
    var entityList = this.jpaRepository.getExercisesByUserId(userId);
    return entityList.stream().map(jpaPersistenceMapper::toExercise).collect(Collectors.toList());
  }

  @Override
  public Optional<Exercise> getExerciseById(@NonNull UUID id) {
    var entity = this.jpaRepository.findById(id);
    return entity.map(this.jpaPersistenceMapper::toExercise);
  }

  @Override
  public Exercise saveExercise(@NonNull Exercise exercise) {
    var entity = this.jpaPersistenceMapper.toExerciseJpaEntity(exercise);
    this.jpaRepository.save(entity);
    return this.jpaPersistenceMapper.toExercise(entity);
  }

  @Override
  public void deleteExercise(@NonNull UUID id) {
    this.jpaRepository.deleteById(id);
  }
}

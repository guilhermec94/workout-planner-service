package com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers;

import com.workout_planner_service.domain.model.Exercise;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.ExerciseJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseJpaPersistenceMapper {
  ExerciseJpaEntity toExerciseJpaEntity(Exercise exercise);

  Exercise toExercise(ExerciseJpaEntity exercise);
}

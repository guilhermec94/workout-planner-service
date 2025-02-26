package com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers;

import com.workout_planner_service.domain.model.Exercise;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.ExerciseJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseJpaPersistenceMapper
    extends BaseJpaPersistenceMapper<Exercise, ExerciseJpaEntity> {}

package com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers;

import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.ExerciseCategoryJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseCategoryJpaPersistenceMapper
    extends BaseJpaPersistenceMapper<ExerciseCategory, ExerciseCategoryJpaEntity> {}

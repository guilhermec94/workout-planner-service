package com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers;

import com.workout_planner_service.domain.model.Workout;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.WorkoutJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkoutJpaPersistenceMapper {

  WorkoutJpaEntity toWorkoutEntity(Workout workout);

  Workout toWorkout(WorkoutJpaEntity workout);
}

package com.workout_planner_service.infrasctructure.adapters.outbound.persistence;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.workout_planner_service.infrastructure.adapters.outbound.persistence.WorkoutPersistenceAdapter;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.mapper.WorkoutJpaPersistenceMapper;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories.WorkoutJpaRepository;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

public class WorkoutPersistenceAdapterTest extends DatabaseTestContainer {
  @Autowired WorkoutPersistenceAdapter persistenceAdapter;
  @Autowired WorkoutJpaRepository jpaRepository;
  @Autowired WorkoutJpaPersistenceMapper jpaMapper;

  @Test
  void shouldThrowExceptionWhenUserIdIsNull() {
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> persistenceAdapter.getAllWorkouts(null);
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  @Sql("/workouts/insert-workouts.sql")
  void shouldRetrieveWorkoutsSuccessfully() {
      
  }
}

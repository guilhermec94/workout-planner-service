package com.workout_planner_service.infrasctructure.adapters.outbound.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.domain.model.Workout;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.WorkoutPersistenceAdapter;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.mapper.WorkoutJpaPersistenceMapper;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories.WorkoutJpaRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@ActiveProfiles("test")
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
    // Given
    var userId = UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea");
    var user =
        User.builder()
            .id(userId)
            .firstName("UserFirstName")
            .lastName("UserLastName")
            .email("user@email.com")
            .build();
    var workout =
        Workout.builder()
            .id(UUID.fromString("d81ef4cd-a6b3-4375-ba8d-467e5a50a988"))
            .name("Workout1")
            .owner(user)
            .createdAt(LocalDateTime.parse("2023-10-25T15:30:00"))
            .build();
    // When
    var data = persistenceAdapter.getAllWorkouts(userId);

    // Then
    assertThat(data).isNotEmpty();
    AssertionsForClassTypes.assertThat(data.get(0)).usingRecursiveComparison().isEqualTo(workout);
  }
}

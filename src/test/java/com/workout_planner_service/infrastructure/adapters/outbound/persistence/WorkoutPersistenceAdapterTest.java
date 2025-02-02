package com.workout_planner_service.infrastructure.adapters.outbound.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.domain.model.Workout;
import java.time.OffsetDateTime;
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

  @Test
  void shouldThrowExceptionWhenUserIdIsNull() {
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> persistenceAdapter.getAllWorkouts(null);
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  @Sql("/workout/insert-user.sql")
  @Sql("/workout/insert-workouts.sql")
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
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    // When
    var data = persistenceAdapter.getAllWorkouts(userId);

    // Then
    assertThat(data).isNotEmpty();
    AssertionsForClassTypes.assertThat(data.get(0)).usingRecursiveComparison().isEqualTo(workout);
  }

  @Test
  void shouldThrowExceptionWhenWorkoutIdIsNullForGet() {
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> persistenceAdapter.getWorkoutById(null);
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  @Sql("/workout/insert-user.sql")
  @Sql("/workout/insert-workouts.sql")
  void shouldRetrieveWorkoutById() {
    // Given
    var workoutId = UUID.fromString("d81ef4cd-a6b3-4375-ba8d-467e5a50a988");
    var user =
        User.builder()
            .id(UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"))
            .firstName("UserFirstName")
            .lastName("UserLastName")
            .email("user@email.com")
            .build();
    var workout =
        Workout.builder()
            .id(workoutId)
            .name("Workout1")
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    // When
    var data = persistenceAdapter.getWorkoutById(workoutId);

    // Then
    assertThat(data).isNotEmpty();
    AssertionsForClassTypes.assertThat(data.get()).usingRecursiveComparison().isEqualTo(workout);
  }

  @Test
  void shouldThrowExceptionIfWorkoutIsNull() {
    ThrowableAssert.ThrowingCallable throwingCallable = () -> persistenceAdapter.saveWorkout(null);
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  @Sql("/workout/insert-user.sql")
  void shouldSaveAWorkout() {
    // Given
    var workoutId = UUID.fromString("d81ef4cd-a6b3-4375-ba8d-467e5a50a988");
    var user =
        User.builder()
            .id(UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"))
            .firstName("UserFirstName")
            .lastName("UserLastName")
            .email("user@email.com")
            .build();
    var workout =
        Workout.builder()
            .id(workoutId)
            .name("Workout1")
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    // When
    var data = persistenceAdapter.saveWorkout(workout);

    // Then
    var workoutFound = persistenceAdapter.getWorkoutById(workoutId);
    assertThat(workoutFound).isNotEmpty();
    assertThat(data).isNotNull();
    AssertionsForClassTypes.assertThat(data).usingRecursiveComparison().isEqualTo(workout);
    AssertionsForClassTypes.assertThat(workoutFound.get())
        .usingRecursiveComparison()
        .isEqualTo(workout);
  }

  @Test
  void shouldThrowExceptionWhenWorkoutIdIsNullForDelete() {
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> persistenceAdapter.deleteWorkout(null);
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  @Sql("/workout/insert-user.sql")
  void shouldDeleteAWorkout() {
    // Given
    var workoutId = UUID.fromString("d81ef4cd-a6b3-4375-ba8d-467e5a50a988");
    var user =
        User.builder()
            .id(UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"))
            .firstName("UserFirstName")
            .lastName("UserLastName")
            .email("user@email.com")
            .build();
    var workout =
        Workout.builder()
            .id(workoutId)
            .name("Workout1")
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    persistenceAdapter.saveWorkout(workout);

    // When
    persistenceAdapter.deleteWorkout(workoutId);

    // Then
    var workoutFound = persistenceAdapter.getWorkoutById(workoutId);
    assertThat(workoutFound).isEmpty();
  }
}

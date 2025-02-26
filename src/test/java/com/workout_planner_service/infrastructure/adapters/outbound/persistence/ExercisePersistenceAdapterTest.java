package com.workout_planner_service.infrastructure.adapters.outbound.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.workout_planner_service.domain.model.Exercise;
import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.domain.model.ExerciseType;
import com.workout_planner_service.domain.model.User;
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
public class ExercisePersistenceAdapterTest extends DatabaseTestContainer {
  @Autowired ExercisePersistenceAdapter persistenceAdapter;

  @Test
  void shouldThrowExceptionWhenUserIdIsNull() {
    ThrowableAssert.ThrowingCallable throwingCallable = () -> persistenceAdapter.getAll(null);
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  @Sql("/exercise/insert-user.sql")
  @Sql("/exercise/insert-category.sql")
  @Sql("/exercise/insert-exercise-type.sql")
  @Sql("/exercise/insert-exercise.sql")
  void shouldRetrieveExerciseSuccessfully() {
    // Given
    var userId = UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea");
    var user =
        User.builder()
            .id(userId)
            .firstName("UserFirstName")
            .lastName("UserLastName")
            .email("user@email.com")
            .build();
    var category =
        ExerciseCategory.builder()
            .id(UUID.fromString("ada096c6-736a-45fe-a17d-d97598befad8"))
            .name("Cat1")
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    var exerciseType =
        ExerciseType.builder()
            .id(UUID.fromString("7b808707-229b-4091-8885-6e575b9d3bc5"))
            .name("type1")
            .build();
    var exercise =
        Exercise.builder()
            .id(UUID.fromString("3c182b69-9a94-4378-99d1-9ad00bee59ab"))
            .name("exercise1")
            .category(category)
            .type(exerciseType)
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    // When
    var data = persistenceAdapter.getAll(userId);

    // Then
    assertThat(data).isNotEmpty();
    AssertionsForClassTypes.assertThat(data.get(0)).usingRecursiveComparison().isEqualTo(exercise);
  }

  @Test
  void shouldThrowExceptionWhenExerciseIdIsNullForGet() {
    ThrowableAssert.ThrowingCallable throwingCallable = () -> persistenceAdapter.getById(null);
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  @Sql("/exercise/insert-user.sql")
  @Sql("/exercise/insert-category.sql")
  @Sql("/exercise/insert-exercise-type.sql")
  @Sql("/exercise/insert-exercise.sql")
  void shouldRetrieveExerciseById() {
    // Given
    var exerciseId = UUID.fromString("3c182b69-9a94-4378-99d1-9ad00bee59ab");
    var user =
        User.builder()
            .id(UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"))
            .firstName("UserFirstName")
            .lastName("UserLastName")
            .email("user@email.com")
            .build();
    var category =
        ExerciseCategory.builder()
            .id(UUID.fromString("ada096c6-736a-45fe-a17d-d97598befad8"))
            .name("Cat1")
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    var exerciseType =
        ExerciseType.builder()
            .id(UUID.fromString("7b808707-229b-4091-8885-6e575b9d3bc5"))
            .name("type1")
            .build();
    var exercise =
        Exercise.builder()
            .id(exerciseId)
            .name("exercise1")
            .category(category)
            .type(exerciseType)
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    // When
    var data = persistenceAdapter.getById(exerciseId);

    // Then
    assertThat(data).isNotEmpty();
    AssertionsForClassTypes.assertThat(data.get()).usingRecursiveComparison().isEqualTo(exercise);
  }

  @Test
  void shouldThrowExceptionIfExerciseIsNull() {
    ThrowableAssert.ThrowingCallable throwingCallable = () -> persistenceAdapter.save(null);
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  @Sql("/exercise/insert-user.sql")
  @Sql("/exercise/insert-category.sql")
  @Sql("/exercise/insert-exercise-type.sql")
  void shouldSaveAExercise() {
    // Given
    var exerciseId = UUID.fromString("3c182b69-9a94-4378-99d1-9ad00bee59ab");
    var user =
        User.builder()
            .id(UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"))
            .firstName("UserFirstName")
            .lastName("UserLastName")
            .email("user@email.com")
            .build();
    var category =
        ExerciseCategory.builder()
            .id(UUID.fromString("ada096c6-736a-45fe-a17d-d97598befad8"))
            .name("Cat1")
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    var exerciseType =
        ExerciseType.builder()
            .id(UUID.fromString("7b808707-229b-4091-8885-6e575b9d3bc5"))
            .name("type1")
            .build();
    var exercise =
        Exercise.builder()
            .id(exerciseId)
            .name("exercise1")
            .category(category)
            .type(exerciseType)
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    // When
    var data = persistenceAdapter.save(exercise);

    // Then
    var exerciseFound = persistenceAdapter.getById(exerciseId);
    assertThat(exerciseFound).isNotEmpty();
    assertThat(data).isNotNull();
    AssertionsForClassTypes.assertThat(data).usingRecursiveComparison().isEqualTo(exercise);
    AssertionsForClassTypes.assertThat(exerciseFound.get())
        .usingRecursiveComparison()
        .isEqualTo(exercise);
  }

  @Test
  void shouldThrowExceptionWhenExerciseIdIsNullForDelete() {
    ThrowableAssert.ThrowingCallable throwingCallable = () -> persistenceAdapter.delete(null);
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  @Sql("/exercise/insert-user.sql")
  @Sql("/exercise/insert-category.sql")
  @Sql("/exercise/insert-exercise-type.sql")
  void shouldDeleteAExercise() {
    // Given
    var exerciseId = UUID.fromString("3c182b69-9a94-4378-99d1-9ad00bee59ab");
    var user =
        User.builder()
            .id(UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"))
            .firstName("UserFirstName")
            .lastName("UserLastName")
            .email("user@email.com")
            .build();
    var category =
        ExerciseCategory.builder()
            .id(UUID.fromString("ada096c6-736a-45fe-a17d-d97598befad8"))
            .name("Cat1")
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    var exerciseType =
        ExerciseType.builder()
            .id(UUID.fromString("7b808707-229b-4091-8885-6e575b9d3bc5"))
            .name("type1")
            .build();
    var exercise =
        Exercise.builder()
            .id(exerciseId)
            .name("exercise1")
            .category(category)
            .type(exerciseType)
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    persistenceAdapter.save(exercise);

    // When
    persistenceAdapter.delete(exerciseId);

    // Then
    var exerciseFound = persistenceAdapter.getById(exerciseId);
    assertThat(exerciseFound).isEmpty();
  }
}

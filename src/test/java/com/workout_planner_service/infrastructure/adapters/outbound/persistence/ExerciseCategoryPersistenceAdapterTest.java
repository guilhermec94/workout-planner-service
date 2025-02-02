package com.workout_planner_service.infrastructure.adapters.outbound.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.workout_planner_service.domain.model.ExerciseCategory;
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
public class ExerciseCategoryPersistenceAdapterTest extends DatabaseTestContainer {
  @Autowired ExerciseCategoryPersistenceAdapter persistenceAdapter;

  @Test
  void shouldThrowExceptionWhenUserIdIsNull() {
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> persistenceAdapter.getAllExerciseCategories(null);
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  @Sql("/exercise/insert-user.sql")
  @Sql("/exerciseCategory/insert-category.sql")
  void shouldRetrieveExerciseCategoriesSuccessfully() {
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
    // When
    var data = persistenceAdapter.getAllExerciseCategories(userId);

    // Then
    assertThat(data).isNotEmpty();
    AssertionsForClassTypes.assertThat(data.get(0)).usingRecursiveComparison().isEqualTo(category);
  }

  @Test
  void shouldThrowExceptionWhenExerciseCategoryIdIsNullForGet() {
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> persistenceAdapter.getExerciseCategoryById(null);
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  @Sql("/exercise/insert-user.sql")
  @Sql("/exerciseCategory/insert-category.sql")
  void shouldRetrieveExerciseCategoryById() {
    // Given
    var categoryId = UUID.fromString("ada096c6-736a-45fe-a17d-d97598befad8");
    var user =
        User.builder()
            .id(UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"))
            .firstName("UserFirstName")
            .lastName("UserLastName")
            .email("user@email.com")
            .build();
    var category =
        ExerciseCategory.builder()
            .id(categoryId)
            .name("Cat1")
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    // When
    var data = persistenceAdapter.getExerciseCategoryById(categoryId);

    // Then
    assertThat(data).isNotEmpty();
    AssertionsForClassTypes.assertThat(data.get()).usingRecursiveComparison().isEqualTo(category);
  }

  @Test
  void shouldThrowExceptionIfExerciseCategoryIsNull() {
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> persistenceAdapter.saveExerciseCategory(null);
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  @Sql("/exerciseCategory/insert-user.sql")
  void shouldSaveAExerciseCategory() {
    // Given
    var categoryId = UUID.fromString("ada096c6-736a-45fe-a17d-d97598befad8");
    var user =
        User.builder()
            .id(UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"))
            .firstName("UserFirstName")
            .lastName("UserLastName")
            .email("user@email.com")
            .build();
    var category =
        ExerciseCategory.builder()
            .id(categoryId)
            .name("Cat1")
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    // When
    var data = persistenceAdapter.saveExerciseCategory(category);

    // Then
    var categoryFound = persistenceAdapter.getExerciseCategoryById(categoryId);
    assertThat(categoryFound).isNotEmpty();
    assertThat(data).isNotNull();
    AssertionsForClassTypes.assertThat(data).usingRecursiveComparison().isEqualTo(category);
    AssertionsForClassTypes.assertThat(categoryFound.get())
        .usingRecursiveComparison()
        .isEqualTo(category);
  }

  @Test
  void shouldThrowExceptionWhenExerciseCategoryIdIsNullForDelete() {
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> persistenceAdapter.deleteExerciseCategory(null);
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  @Sql("/exerciseCategory/insert-user.sql")
  void shouldDeleteAExerciseCategory() {
    // Given
    var categoryId = UUID.fromString("ada096c6-736a-45fe-a17d-d97598befad8");
    var user =
        User.builder()
            .id(UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"))
            .firstName("UserFirstName")
            .lastName("UserLastName")
            .email("user@email.com")
            .build();
    var category =
        ExerciseCategory.builder()
            .id(categoryId)
            .name("Cat1")
            .owner(user)
            .createdAt(OffsetDateTime.parse("2023-10-25T15:30:00"))
            .build();
    persistenceAdapter.saveExerciseCategory(category);

    // When
    persistenceAdapter.deleteExerciseCategory(categoryId);

    // Then
    var categoryFound = persistenceAdapter.getExerciseCategoryById(categoryId);
    assertThat(categoryFound).isEmpty();
  }
}

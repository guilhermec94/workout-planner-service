package com.workout_planner_service.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.workout_planner_service.application.exceptions.ExerciseCategoryNotFoundException;
import com.workout_planner_service.application.exceptions.UserNotFoundException;
import com.workout_planner_service.application.ports.ExerciseCategoryEntityMapper;
import com.workout_planner_service.application.ports.outbound.persistence.ExerciseCategoryPersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseCategoryDTO;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExerciseCategoryUseCaseImplTest {

  @Mock private ExerciseCategoryEntityMapper entityMapper;
  @Mock private UserPersistencePort userPersistencePort;
  @Mock private ExerciseCategoryPersistencePort exerciseCategoryPersistencePort;
  @InjectMocks private ExerciseCategoryUseCaseImpl exerciseCategoryUseCaseImpl;

  @Test
  void shouldThrowExceptionWhenUserIdIsNullGettingAllExerciseCategories() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseCategoryUseCaseImpl.getAllExerciseCategories(null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldListExerciseCategorysSuccessfully() {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();
    var categories =
        List.of(
            ExerciseCategory.builder()
                .id(UUID.randomUUID())
                .name("C1")
                .owner(user)
                .createdAt(OffsetDateTime.now())
                .build(),
            ExerciseCategory.builder()
                .id(UUID.randomUUID())
                .name("C2")
                .owner(user)
                .createdAt(OffsetDateTime.now())
                .build());

    var categoryDTOs =
        List.of(
            ExerciseCategoryDTO.builder()
                .id(UUID.randomUUID())
                .name("C1")
                .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
                .build(),
            ExerciseCategoryDTO.builder()
                .id(UUID.randomUUID())
                .name("C2")
                .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
                .build());

    when(entityMapper.toDTO(categories.get(0))).thenReturn(categoryDTOs.get(0));
    when(entityMapper.toDTO(categories.get(1))).thenReturn(categoryDTOs.get(1));
    when(exerciseCategoryPersistencePort.getAllExerciseCategories(userId)).thenReturn(categories);

    // When
    var result = exerciseCategoryUseCaseImpl.getAllExerciseCategories(userId);

    // Then
    assertThat(result).isNotEmpty();
    assertThat(result).containsExactlyInAnyOrderElementsOf(categoryDTOs);
  }

  @Test
  void shouldThrowExceptionWhenExerciseCategoryIdIsNullGettingExerciseCategory() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseCategoryUseCaseImpl.getExerciseCategoryById(null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldGetExerciseCategoryByIdSuccessfully() {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();
    var category =
        ExerciseCategory.builder()
            .id(UUID.randomUUID())
            .name("C1")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var categoryDTO =
        ExerciseCategoryDTO.builder()
            .id(UUID.randomUUID())
            .name("C1")
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();

    when(entityMapper.toDTO(category)).thenReturn(categoryDTO);
    when(exerciseCategoryPersistencePort.getExerciseCategoryById(category.getId()))
        .thenReturn(Optional.of(category));

    // When
    var result = exerciseCategoryUseCaseImpl.getExerciseCategoryById(category.getId());

    // Then
    assertThat(result).isNotEmpty();
    assertThat(result).containsSame(categoryDTO);
  }

  @Test
  void shouldThrowExceptionWhenExerciseCategoryIsNullCreatingExerciseCategory() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseCategoryUseCaseImpl.createExerciseCategory(null, UUID.randomUUID());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenUserIDIsNullCreatingExerciseCategory() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseCategoryUseCaseImpl.createExerciseCategory(mock(), null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenUserIsNotFoundCreatingExerciseCategory() {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();

    var categoryDTO =
        ExerciseCategoryDTO.builder()
            .name("C1")
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();

    when(userPersistencePort.GetByID(any())).thenReturn(Optional.empty());

    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseCategoryUseCaseImpl.createExerciseCategory(categoryDTO, user.getId());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(UserNotFoundException.class);
  }

  @Test
  void shouldCreateExerciseCategorySuccessfully() {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();
    var category =
        ExerciseCategory.builder().name("W1").owner(user).createdAt(OffsetDateTime.now()).build();

    var categorySaved =
        ExerciseCategory.builder()
            .id(UUID.randomUUID())
            .name("C1")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var categoryDTO =
        ExerciseCategoryDTO.builder()
            .name("C1")
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();
    var categorySavedDTO =
        ExerciseCategoryDTO.builder()
            .id(categorySaved.getId())
            .name("C1")
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();

    when(entityMapper.toDomain(categoryDTO, user)).thenReturn(category);
    when(entityMapper.toDTO(categorySaved)).thenReturn(categorySavedDTO);
    when(userPersistencePort.GetByID(any())).thenReturn(Optional.ofNullable(user));
    when(exerciseCategoryPersistencePort.saveExerciseCategory(category)).thenReturn(categorySaved);

    // When
    var result = exerciseCategoryUseCaseImpl.createExerciseCategory(categoryDTO, user.getId());

    // Then
    assertThat(result).isEqualTo(categoryDTO);
  }

  @Test
  void shouldThrowExceptionWhenExerciseCategoryIsNullPatchingExerciseCategory() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () ->
            exerciseCategoryUseCaseImpl.patchExerciseCategory(
                null, UUID.randomUUID(), UUID.randomUUID());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenExerciseCategoryIDIsNullPatchingExerciseCategory() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseCategoryUseCaseImpl.patchExerciseCategory(mock(), null, UUID.randomUUID());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenUserIDIsNullPatchingExerciseCategory() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseCategoryUseCaseImpl.patchExerciseCategory(mock(), UUID.randomUUID(), null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenUserIsNotFoundPatchingExerciseCategory() {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();

    var categorySaved =
        ExerciseCategory.builder()
            .id(UUID.randomUUID())
            .name("C1Patch")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var categoryDTO =
        ExerciseCategoryDTO.builder()
            .name("C1")
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();

    when(userPersistencePort.GetByID(any())).thenReturn(Optional.empty());

    /// When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () ->
            exerciseCategoryUseCaseImpl.patchExerciseCategory(
                categoryDTO, categorySaved.getId(), user.getId());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(UserNotFoundException.class);
  }

  @Test
  void shouldThrowExceptionWhenExerciseCategoryIsNotFoundPatchingExerciseCategory() {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();

    var categorySaved =
        ExerciseCategory.builder()
            .id(UUID.randomUUID())
            .name("C1Patch")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var categoryDTO =
        ExerciseCategoryDTO.builder()
            .name("C1")
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();

    when(userPersistencePort.GetByID(any())).thenReturn(Optional.ofNullable(user));
    when(exerciseCategoryPersistencePort.getExerciseCategoryById(categorySaved.getId()))
        .thenReturn(Optional.empty());

    /// When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () ->
            exerciseCategoryUseCaseImpl.patchExerciseCategory(
                categoryDTO, categorySaved.getId(), user.getId());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(ExerciseCategoryNotFoundException.class);
  }

  @Test
  void shouldPatchExerciseCategorySuccessfully() {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();

    var categorySaved =
        ExerciseCategory.builder()
            .id(UUID.randomUUID())
            .name("C1Patch")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var categoryDTO =
        ExerciseCategoryDTO.builder()
            .name("C1")
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();
    when(userPersistencePort.GetByID(any())).thenReturn(Optional.ofNullable(user));
    when(exerciseCategoryPersistencePort.getExerciseCategoryById(categorySaved.getId()))
        .thenReturn(Optional.of(categorySaved));
    when(exerciseCategoryPersistencePort.saveExerciseCategory(categorySaved))
        .thenReturn(categorySaved);

    // When
    exerciseCategoryUseCaseImpl.patchExerciseCategory(
        categoryDTO, categorySaved.getId(), user.getId());

    // Then
    verify(userPersistencePort, times(1)).GetByID(any());
    verify(exerciseCategoryPersistencePort, times(1)).getExerciseCategoryById(any());
    verify(exerciseCategoryPersistencePort, times(1)).saveExerciseCategory(any());
  }

  @Test
  void shouldDeleteExerciseCategorySuccessfully() {
    // When
    exerciseCategoryUseCaseImpl.deleteExerciseCategory(UUID.randomUUID());

    // Then
    verify(exerciseCategoryPersistencePort, times(1)).deleteExerciseCategory(any());
  }

  @Test
  void shouldThrowExceptionWhenExerciseCategoryIdIsNullDeletingExerciseCategory() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseCategoryUseCaseImpl.deleteExerciseCategory(null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }
}

package com.workout_planner_service.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.workout_planner_service.application.exceptions.EntityNotFoundException;
import com.workout_planner_service.application.exceptions.ExerciseCategoryNotFoundException;
import com.workout_planner_service.application.exceptions.UserNotFoundException;
import com.workout_planner_service.application.ports.ExerciseEntityMapper;
import com.workout_planner_service.application.ports.outbound.persistence.ExerciseCategoryPersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.ExercisePersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.domain.model.Exercise;
import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExerciseUseCaseImplTest extends TestImplBase<ExerciseDTO> {

  @Mock private ExerciseEntityMapper entityMapper;
  @Mock private UserPersistencePort userPersistencePort;
  @Mock private ExerciseCategoryPersistencePort exerciseCategoryPersistencePort;
  @Mock private ExercisePersistencePort exercisePersistencePort;

  @Spy
  private ObjectMapper objectMapper =
      new ObjectMapper()
          .registerModule(new JavaTimeModule())
          .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

  @InjectMocks private ExerciseUseCaseImpl exerciseUseCaseImpl;

  @Test
  void shouldThrowExceptionWhenUserIdIsNullGettingAllExercises() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseUseCaseImpl.getAllExercises(null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldListExercisesSuccessfully() {
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
    var exercises =
        List.of(
            Exercise.builder()
                .id(UUID.randomUUID())
                .name("E1")
                .category(category)
                .owner(user)
                .createdAt(OffsetDateTime.now())
                .build(),
            Exercise.builder()
                .id(UUID.randomUUID())
                .name("E2")
                .category(category)
                .owner(user)
                .createdAt(OffsetDateTime.now())
                .build());

    var exciseDTOs =
        List.of(
            ExerciseDTO.builder()
                .id(UUID.randomUUID())
                .name("E1")
                .categoryId(category.getId())
                .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
                .build(),
            ExerciseDTO.builder()
                .id(UUID.randomUUID())
                .name("E2")
                .categoryId(category.getId())
                .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
                .build());

    when(entityMapper.toDTO(exercises.get(0))).thenReturn(exciseDTOs.get(0));
    when(entityMapper.toDTO(exercises.get(1))).thenReturn(exciseDTOs.get(1));
    when(exercisePersistencePort.getAll(userId)).thenReturn(exercises);

    // When
    var result = exerciseUseCaseImpl.getAllExercises(userId);

    // Then
    assertThat(result).isNotEmpty();
    assertThat(result).containsExactlyInAnyOrderElementsOf(exciseDTOs);
  }

  @Test
  void shouldThrowExceptionWhenExerciseIdIsNullGettingExercise() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable = () -> exerciseUseCaseImpl.getById(null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldGetExerciseByIdSuccessfully() {
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
    var exercise =
        Exercise.builder()
            .id(UUID.randomUUID())
            .name("E1")
            .category(category)
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();
    var exerciseDTO =
        ExerciseDTO.builder()
            .id(UUID.randomUUID())
            .name("E1")
            .categoryId(category.getId())
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();

    when(entityMapper.toDTO(exercise)).thenReturn(exerciseDTO);
    when(exercisePersistencePort.getById(exercise.getId())).thenReturn(Optional.of(exercise));

    // When
    var result = exerciseUseCaseImpl.getById(exercise.getId());

    // Then
    assertThat(result).isNotEmpty();
    assertThat(result).containsSame(exerciseDTO);
  }

  @Test
  void shouldThrowExceptionWhenExerciseIsNullCreatingExercise() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseUseCaseImpl.createExercise(null, UUID.randomUUID());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenUserIDIsNullCreatingExercise() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseUseCaseImpl.createExercise(mock(), null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenUserIsNotFoundCreatingExercise() {
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

    var exerciseDTO =
        ExerciseDTO.builder()
            .id(UUID.randomUUID())
            .name("E1")
            .categoryId(category.getId())
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();

    when(userPersistencePort.getById(any())).thenReturn(Optional.empty());

    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseUseCaseImpl.createExercise(exerciseDTO, user.getId());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(UserNotFoundException.class);
  }

  @Test
  void shouldThrowExceptionWhenCategoryIsNotFoundCreatingExercise() {
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

    var exerciseDTO =
        ExerciseDTO.builder()
            .id(UUID.randomUUID())
            .name("E1")
            .categoryId(category.getId())
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();

    when(userPersistencePort.getById(any())).thenReturn(Optional.ofNullable(user));
    when(exerciseCategoryPersistencePort.getById(any())).thenReturn(Optional.empty());

    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseUseCaseImpl.createExercise(exerciseDTO, user.getId());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(ExerciseCategoryNotFoundException.class);
  }

  @Test
  void shouldCreateExerciseSuccessfully() {
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
    var exercise =
        Exercise.builder()
            .name("E1")
            .category(category)
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();
    var exerciseSaved =
        Exercise.builder()
            .id(UUID.randomUUID())
            .name("E1")
            .category(category)
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();
    var exerciseDTO =
        ExerciseDTO.builder()
            .name("E1")
            .categoryId(category.getId())
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();
    var exerciseSavedDTO =
        ExerciseDTO.builder()
            .id(exerciseSaved.getId())
            .name("E1")
            .categoryId(category.getId())
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();

    when(entityMapper.toDomain(exerciseDTO)).thenReturn(exercise);
    when(entityMapper.toDTO(exerciseSaved)).thenReturn(exerciseSavedDTO);
    when(userPersistencePort.getById(any())).thenReturn(Optional.ofNullable(user));
    when(exerciseCategoryPersistencePort.getById(category.getId()))
        .thenReturn(Optional.of(category));
    when(exercisePersistencePort.save(exercise)).thenReturn(exerciseSaved);

    // When
    var result = exerciseUseCaseImpl.createExercise(exerciseDTO, user.getId());

    // Then
    assertThat(result).isEqualTo(exerciseSavedDTO);
  }

  @Test
  void shouldThrowExceptionWhenExerciseCategoryIsNullPatchingExercise() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseUseCaseImpl.patchExercise(null, UUID.randomUUID(), UUID.randomUUID());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenExerciseIDIsNullPatchingExercise() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseUseCaseImpl.patchExercise(mock(), null, UUID.randomUUID());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenUserIDIsNullPatchingExercise() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseUseCaseImpl.patchExercise(mock(), UUID.randomUUID(), null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenUserIsNotFoundPatchingExercise() {
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

    var newCategory =
        ExerciseCategory.builder()
            .id(UUID.randomUUID())
            .name("C2")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var exerciseSaved =
        Exercise.builder()
            .id(UUID.randomUUID())
            .name("E1")
            .category(category)
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var exerciseDTO =
        ExerciseDTO.builder()
            .id(exerciseSaved.getId())
            .name("E1")
            .categoryId(category.getId())
            .createdAt(exerciseSaved.getCreatedAt())
            .build();

    ExerciseDTO updatedExercise =
        ExerciseDTO.builder()
            .id(exerciseSaved.getId())
            .name("E1Patch")
            .categoryId(newCategory.getId())
            .createdAt(exerciseSaved.getCreatedAt())
            .build();
    JsonPatch patch = generatePatch(exerciseDTO, updatedExercise);

    when(userPersistencePort.getById(any())).thenReturn(Optional.empty());

    /// When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseUseCaseImpl.patchExercise(patch, exerciseSaved.getId(), user.getId());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(UserNotFoundException.class);
  }

  @Test
  void shouldThrowExceptionWhenCategoryIsNotFoundPatchingExercise() {
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

    var newCategory =
        ExerciseCategory.builder()
            .id(UUID.randomUUID())
            .name("C2")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var exerciseSaved =
        Exercise.builder()
            .id(UUID.randomUUID())
            .name("E1")
            .category(category)
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var exerciseDTO =
        ExerciseDTO.builder()
            .id(exerciseSaved.getId())
            .name("E1")
            .categoryId(category.getId())
            .createdAt(exerciseSaved.getCreatedAt())
            .build();

    ExerciseDTO updatedExercise =
        ExerciseDTO.builder()
            .id(exerciseSaved.getId())
            .name("E1Patch")
            .categoryId(newCategory.getId())
            .createdAt(exerciseSaved.getCreatedAt())
            .build();
    JsonPatch patch = generatePatch(exerciseDTO, updatedExercise);

    when(userPersistencePort.getById(any())).thenReturn(Optional.ofNullable(user));
    when(exerciseCategoryPersistencePort.getById(newCategory.getId())).thenReturn(Optional.empty());

    /// When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseUseCaseImpl.patchExercise(patch, exerciseSaved.getId(), user.getId());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(ExerciseCategoryNotFoundException.class);
  }

  @Test
  void shouldThrowExceptionWhenExerciseIsNotFoundPatchingExercise() {
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

    var newCategory =
        ExerciseCategory.builder()
            .id(UUID.randomUUID())
            .name("C2")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var exerciseSaved =
        Exercise.builder()
            .id(UUID.randomUUID())
            .name("E1")
            .category(category)
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var exerciseDTO =
        ExerciseDTO.builder()
            .id(exerciseSaved.getId())
            .name("E1")
            .categoryId(category.getId())
            .createdAt(exerciseSaved.getCreatedAt())
            .build();

    ExerciseDTO updatedExercise =
        ExerciseDTO.builder()
            .id(exerciseSaved.getId())
            .name("E1Patch")
            .categoryId(newCategory.getId())
            .createdAt(exerciseSaved.getCreatedAt())
            .build();
    JsonPatch patch = generatePatch(exerciseDTO, updatedExercise);

    when(userPersistencePort.getById(any())).thenReturn(Optional.ofNullable(user));
    when(exerciseCategoryPersistencePort.getById(newCategory.getId()))
        .thenReturn(Optional.of(category));
    when(exercisePersistencePort.getById(exerciseSaved.getId())).thenReturn(Optional.empty());

    /// When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> exerciseUseCaseImpl.patchExercise(patch, exerciseSaved.getId(), user.getId());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(EntityNotFoundException.class);
  }

  @Test
  void shouldPatchExerciseCategorySuccessfully() throws JsonPatchException, IOException {
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

    var newCategory =
        ExerciseCategory.builder()
            .id(UUID.randomUUID())
            .name("C2")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var exerciseSaved =
        Exercise.builder()
            .id(UUID.randomUUID())
            .name("E1")
            .category(category)
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var exerciseDTO =
        ExerciseDTO.builder()
            .id(exerciseSaved.getId())
            .name("E1")
            .categoryId(category.getId())
            .createdAt(exerciseSaved.getCreatedAt())
            .build();

    ExerciseDTO updatedExercise =
        ExerciseDTO.builder()
            .id(exerciseSaved.getId())
            .name("E1Patch")
            .categoryId(newCategory.getId())
            .createdAt(exerciseSaved.getCreatedAt())
            .build();
    JsonPatch patch = generatePatch(exerciseDTO, updatedExercise);

    when(userPersistencePort.getById(any())).thenReturn(Optional.ofNullable(user));
    when(exerciseCategoryPersistencePort.getById(newCategory.getId()))
        .thenReturn(Optional.of(category));
    when(exercisePersistencePort.getById(exerciseSaved.getId()))
        .thenReturn(Optional.of(exerciseSaved));

    // When
    exerciseUseCaseImpl.patchExercise(patch, exerciseSaved.getId(), user.getId());

    // Then
    verify(userPersistencePort, times(1)).getById(any());
    verify(exerciseCategoryPersistencePort, times(1)).getById(any());
    verify(exercisePersistencePort, times(1)).getById(any());
    verify(exercisePersistencePort, times(1)).save(any());
  }

  @Test
  void shouldDeleteExerciseCategorySuccessfully() {
    // When
    exerciseUseCaseImpl.delete(UUID.randomUUID());

    // Then
    verify(exercisePersistencePort, times(1)).delete(any());
  }

  @Test
  void shouldThrowExceptionWhenExerciseCategoryIdIsNullDeletingExerciseCategory() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable = () -> exerciseUseCaseImpl.delete(null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }
}

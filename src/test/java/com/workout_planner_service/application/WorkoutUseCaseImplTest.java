package com.workout_planner_service.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.workout_planner_service.application.exceptions.EntityNotFoundException;
import com.workout_planner_service.application.exceptions.UserNotFoundException;
import com.workout_planner_service.application.ports.WorkoutEntityMapper;
import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.application.ports.outbound.persistence.WorkoutPersistencePort;
import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.domain.model.Workout;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutDTO;
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
class WorkoutUseCaseImplTest extends TestImplBase<WorkoutDTO> {

  @Mock private WorkoutEntityMapper entityMapper;
  @Mock private UserPersistencePort userPersistencePort;
  @Mock private WorkoutPersistencePort workoutPersistencePort;

  @Spy
  private ObjectMapper objectMapper =
      new ObjectMapper()
          .registerModule(new JavaTimeModule())
          .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

  @InjectMocks private WorkoutUseCaseImpl workoutUseCaseImpl;

  @Test
  void shouldThrowExceptionWhenUserIdIsNullGettingAllWorkouts() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> workoutUseCaseImpl.getAllWorkouts(null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldListWorkoutsSuccessfully() {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();
    var workouts =
        List.of(
            Workout.builder()
                .id(UUID.randomUUID())
                .name("W1")
                .owner(user)
                .createdAt(OffsetDateTime.now())
                .build(),
            Workout.builder()
                .id(UUID.randomUUID())
                .name("W2")
                .owner(user)
                .createdAt(OffsetDateTime.now())
                .build());

    var workoutDTOs =
        List.of(
            WorkoutDTO.builder()
                .id(UUID.randomUUID())
                .name("W1")
                .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
                .build(),
            WorkoutDTO.builder()
                .id(UUID.randomUUID())
                .name("W2")
                .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
                .build());

    when(entityMapper.toDTO(workouts.get(0))).thenReturn(workoutDTOs.get(0));
    when(entityMapper.toDTO(workouts.get(1))).thenReturn(workoutDTOs.get(1));
    when(workoutPersistencePort.getAll(userId)).thenReturn(workouts);

    // When
    var result = workoutUseCaseImpl.getAllWorkouts(userId);

    // Then
    assertThat(result).isNotEmpty();
    assertThat(result).containsExactlyInAnyOrderElementsOf(workoutDTOs);
  }

  @Test
  void shouldThrowExceptionWhenWorkoutIdIsNullGettingWorkout() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable = () -> workoutUseCaseImpl.getById(null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldGetWorkoutByIdSuccessfully() {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();
    var workout =
        Workout.builder()
            .id(UUID.randomUUID())
            .name("W1")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var workoutDTO =
        WorkoutDTO.builder()
            .id(UUID.randomUUID())
            .name("W1")
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();

    when(entityMapper.toDTO(workout)).thenReturn(workoutDTO);
    when(workoutPersistencePort.getById(workout.getId())).thenReturn(Optional.of(workout));

    // When
    var result = workoutUseCaseImpl.getById(workout.getId());

    // Then
    assertThat(result).isNotEmpty();
    assertThat(result).containsSame(workoutDTO);
  }

  @Test
  void shouldThrowExceptionWhenWorkoutIsNullCreatingWorkout() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> workoutUseCaseImpl.createWorkout(null, UUID.randomUUID());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenUserIDIsNullCreatingWorkout() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> workoutUseCaseImpl.createWorkout(mock(), null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenUserIsNotFoundCreatingWorkout() {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();

    var workoutDTO =
        WorkoutDTO.builder()
            .id(UUID.randomUUID())
            .name("W1")
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();

    when(userPersistencePort.getById(any())).thenReturn(Optional.empty());

    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> workoutUseCaseImpl.createWorkout(workoutDTO, user.getId());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(UserNotFoundException.class);
  }

  @Test
  void shouldCreateWorkoutSuccessfully() {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();
    var workout = Workout.builder().name("W1").owner(user).createdAt(OffsetDateTime.now()).build();

    var workoutSaved =
        Workout.builder()
            .id(UUID.randomUUID())
            .name("W1")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var workoutDTO =
        WorkoutDTO.builder()
            .name("W1")
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();

    var workoutSavedDTO =
        WorkoutDTO.builder()
            .id(workoutSaved.getId())
            .name("W1")
            .createdAt(OffsetDateTime.from(OffsetDateTime.now()))
            .build();

    when(entityMapper.toDomain(workoutDTO)).thenReturn(workout);
    when(entityMapper.toDTO(workoutSaved)).thenReturn(workoutSavedDTO);
    when(userPersistencePort.getById(any())).thenReturn(Optional.ofNullable(user));
    when(workoutPersistencePort.save(workout)).thenReturn(workoutSaved);

    // When
    var result = workoutUseCaseImpl.createWorkout(workoutDTO, user.getId());

    // Then
    assertThat(result).isEqualTo(workoutSavedDTO);
  }

  @Test
  void shouldThrowExceptionWhenWorkoutIsNullPatchingWorkout() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> workoutUseCaseImpl.patchWorkout(null, UUID.randomUUID(), UUID.randomUUID());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenWorkoutIDIsNullPatchingWorkout() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> workoutUseCaseImpl.patchWorkout(mock(), null, UUID.randomUUID());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenUserIDIsNullPatchingWorkout() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> workoutUseCaseImpl.patchWorkout(mock(), UUID.randomUUID(), null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldThrowExceptionWhenUserIsNotFoundPatchingWorkout() {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();

    var workoutSaved =
        Workout.builder()
            .id(UUID.randomUUID())
            .name("W1")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var workoutDTO =
        WorkoutDTO.builder()
            .id(workoutSaved.getId())
            .name("W1")
            .createdAt(workoutSaved.getCreatedAt())
            .build();

    WorkoutDTO updatedWorkout =
        WorkoutDTO.builder()
            .id(workoutSaved.getId())
            .name("W1Patch")
            .createdAt(workoutSaved.getCreatedAt())
            .build();
    JsonPatch patch = this.generatePatch(workoutDTO, updatedWorkout);

    when(userPersistencePort.getById(any())).thenReturn(Optional.empty());

    /// When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> workoutUseCaseImpl.patchWorkout(patch, workoutSaved.getId(), user.getId());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(UserNotFoundException.class);
  }

  @Test
  void shouldThrowExceptionWhenWorkoutIsNotFoundPatchingWorkout() {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();

    var workoutSaved =
        Workout.builder()
            .id(UUID.randomUUID())
            .name("W1")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var workoutDTO =
        WorkoutDTO.builder()
            .id(workoutSaved.getId())
            .name("W1")
            .createdAt(workoutSaved.getCreatedAt())
            .build();

    WorkoutDTO updatedWorkout =
        WorkoutDTO.builder()
            .id(workoutSaved.getId())
            .name("W1Patch")
            .createdAt(workoutSaved.getCreatedAt())
            .build();
    JsonPatch patch = this.generatePatch(workoutDTO, updatedWorkout);

    when(userPersistencePort.getById(any())).thenReturn(Optional.ofNullable(user));
    when(workoutPersistencePort.getById(workoutSaved.getId())).thenReturn(Optional.empty());

    /// When
    ThrowableAssert.ThrowingCallable throwingCallable =
        () -> workoutUseCaseImpl.patchWorkout(patch, workoutSaved.getId(), user.getId());

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(EntityNotFoundException.class);
  }

  @Test
  void shouldPatchWorkoutSuccessfully() throws JsonPatchException, JsonProcessingException {
    // Given
    var userId = UUID.randomUUID();
    var user =
        User.builder()
            .id(userId)
            .firstName("User1")
            .lastName("Last")
            .email("email@test.com")
            .build();

    var workoutSaved =
        Workout.builder()
            .id(UUID.randomUUID())
            .name("W1")
            .owner(user)
            .createdAt(OffsetDateTime.now())
            .build();

    var workoutDTO =
        WorkoutDTO.builder()
            .id(workoutSaved.getId())
            .name("W1")
            .createdAt(workoutSaved.getCreatedAt())
            .build();

    WorkoutDTO updatedWorkout =
        WorkoutDTO.builder()
            .id(workoutSaved.getId())
            .name("W1Patch")
            .createdAt(workoutSaved.getCreatedAt())
            .build();
    JsonPatch patch = generatePatch(workoutDTO, updatedWorkout);

    when(userPersistencePort.getById(any())).thenReturn(Optional.ofNullable(user));
    when(workoutPersistencePort.getById(workoutSaved.getId()))
        .thenReturn(Optional.of(workoutSaved));

    // When
    workoutUseCaseImpl.patchWorkout(patch, workoutSaved.getId(), user.getId());

    // Then
    verify(userPersistencePort, times(1)).getById(any());
    verify(workoutPersistencePort, times(1)).getById(any());
    verify(workoutPersistencePort, times(1)).save(any());
  }

  @Test
  void shouldDeleteWorkoutSuccessfully() {
    // When
    workoutUseCaseImpl.delete(UUID.randomUUID());

    // Then
    verify(workoutPersistencePort, times(1)).delete(any());
  }

  @Test
  void shouldThrowExceptionWhenWorkoutIdIsNullDeletingWorkout() {
    // When
    ThrowableAssert.ThrowingCallable throwingCallable = () -> workoutUseCaseImpl.delete(null);

    // Then
    assertThatThrownBy(throwingCallable).isInstanceOf(NullPointerException.class);
  }
}

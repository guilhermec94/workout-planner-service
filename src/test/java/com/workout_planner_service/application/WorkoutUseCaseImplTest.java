package com.workout_planner_service.application;

import com.workout_planner_service.application.ports.WorkoutEntityMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WorkoutUseCaseImplTest {

  @Mock private WorkoutEntityMapper entityMapper;

  @InjectMocks private WorkoutUseCaseImpl workoutUseCaseImpl;

  void shouldListWorkoutsSuccessfully() {
    // Given

    // When

    // Then
  }
}

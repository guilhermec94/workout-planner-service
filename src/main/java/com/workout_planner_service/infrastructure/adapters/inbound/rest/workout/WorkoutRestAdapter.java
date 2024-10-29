package com.workout_planner_service.infrastructure.adapters.inbound.rest.workout;

import com.workout_planner_service.application.ports.inbound.WorkoutUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class WorkoutRestAdapter {
  private final WorkoutUseCase workoutUseCase;

  @PostMapping(value = "/workouts")
  public void createWorkout() {}
}

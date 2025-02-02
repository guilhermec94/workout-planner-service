package com.workout_planner_service.application.exceptions;

public class WorkoutNotFoundException extends RuntimeException {
  public WorkoutNotFoundException(String message) {
    super(message);
  }
}

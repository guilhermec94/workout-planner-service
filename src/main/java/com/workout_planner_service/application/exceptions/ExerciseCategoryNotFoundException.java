package com.workout_planner_service.application.exceptions;

public class ExerciseCategoryNotFoundException extends RuntimeException {
  public ExerciseCategoryNotFoundException(String message) {
    super(message);
  }
}

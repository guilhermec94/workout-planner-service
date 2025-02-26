package com.workout_planner_service.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
public class Exercise extends BaseEntity {
  private String name;
  private ExerciseCategory category;
  private ExerciseType type;
  private User owner;

  @Builder
  Exercise(
      UUID id,
      String name,
      ExerciseCategory category,
      ExerciseType type,
      User owner,
      OffsetDateTime createdAt) {
    super(id, createdAt);
    this.name = name;
    this.category = category;
    this.type = type;
    this.owner = owner;
  }
}

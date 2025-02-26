package com.workout_planner_service.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
public class ExerciseType extends BaseEntity {
  private String name;
  private String weightUnit;
  private String distanceUnit;

  @Builder
  ExerciseType(
      UUID id, String name, String weightUnit, String distanceUnit, OffsetDateTime createdAt) {
    super(id, createdAt);
    this.name = name;
    this.weightUnit = weightUnit;
    this.distanceUnit = distanceUnit;
  }
}

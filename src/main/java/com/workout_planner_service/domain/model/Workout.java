package com.workout_planner_service.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
public class Workout extends BaseEntity {
  private String name;
  private User owner;

  @Builder
  Workout(UUID id, String name, User owner, OffsetDateTime createdAt) {
    super(id, createdAt);
    this.name = name;
    this.owner = owner;
  }
}

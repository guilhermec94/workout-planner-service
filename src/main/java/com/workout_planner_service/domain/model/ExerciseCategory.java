package com.workout_planner_service.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
public class ExerciseCategory extends BaseEntity {
  private String name;
  private User owner;

  @JsonCreator
  @Builder
  ExerciseCategory(
      @JsonProperty("id") UUID id,
      @JsonProperty("name") String name,
      @JsonProperty("owner") User owner,
      @JsonProperty("createdAt") OffsetDateTime createdAt) {
    super(id, createdAt);
    this.name = name;
    this.owner = owner;
  }
}

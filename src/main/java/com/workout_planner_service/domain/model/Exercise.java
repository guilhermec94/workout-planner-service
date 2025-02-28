package com.workout_planner_service.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

  @JsonCreator
  @Builder
  Exercise(
      @JsonProperty("id") UUID id,
      @JsonProperty("name") String name,
      @JsonProperty("category") ExerciseCategory category,
      @JsonProperty("type") ExerciseType type,
      @JsonProperty("owner") User owner,
      @JsonProperty("createdAt") OffsetDateTime createdAt) {
    super(id, createdAt);
    this.name = name;
    this.category = category;
    this.type = type;
    this.owner = owner;
  }
}

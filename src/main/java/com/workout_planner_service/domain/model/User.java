package com.workout_planner_service.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
public class User extends BaseEntity {
  private String firstName;
  private String lastName;
  private String email;

  @JsonCreator
  @Builder
  User(
      @JsonProperty("id") UUID id,
      @JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName,
      @JsonProperty("email") String email,
      @JsonProperty("createdAt") OffsetDateTime createdAt) {
    super(id, createdAt);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}

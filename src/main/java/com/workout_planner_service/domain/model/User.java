package com.workout_planner_service.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
public class User extends BaseEntity {
  private String firstName;
  private String lastName;
  private String email;

  @Builder
  User(UUID id, String firstName, String lastName, String email, OffsetDateTime createdAt) {
    super(id, createdAt);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}

package com.workout_planner_service.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public abstract class BaseEntity {
  private UUID id;
  private OffsetDateTime createdAt;
}

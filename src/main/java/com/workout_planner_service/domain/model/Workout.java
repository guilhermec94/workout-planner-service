package com.workout_planner_service.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Workout {
  private UUID id;
  private String name;
  private User owner;
  private OffsetDateTime createdAt;
}

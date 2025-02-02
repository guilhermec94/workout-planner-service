package com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exercise_categories")
public class ExerciseCategoryJpaEntity {
  @Id private UUID id;
  private String name;

  @ManyToOne
  @JoinColumn(name = "owner")
  private UserJpaEntity owner;

  private OffsetDateTime createdAt;
}

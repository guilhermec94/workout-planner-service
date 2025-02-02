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
@Table(name = "exercises")
public class ExerciseJpaEntity {
  @Id private UUID id;
  private String name;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private ExerciseCategoryJpaEntity category;

  @ManyToOne
  @JoinColumn(name = "exercise_type_id")
  private ExerciseTypeJpaEntity type;

  @ManyToOne
  @JoinColumn(name = "owner")
  private UserJpaEntity owner;

  private OffsetDateTime createdAt;
}

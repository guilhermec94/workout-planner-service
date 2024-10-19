package com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
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
  @Id
  private UUID id;
  private String name;
  @ManyToOne private ExerciseCategoryJpaEntity category;
  @ManyToOne private ExerciseTypeJpaEntity type;
  @ManyToOne private UserJpaEntity owner;
  private LocalDateTime createdAt;
}

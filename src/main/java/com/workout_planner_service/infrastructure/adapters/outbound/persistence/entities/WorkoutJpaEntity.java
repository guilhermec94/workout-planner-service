package com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "workouts")
public class WorkoutJpaEntity {
  @Id private UUID id;

  private String name;

  @ManyToMany
  @JoinTable(name = "workout_exercises", joinColumns = @JoinColumn(name = "workout_id"))
  private List<ExerciseJpaEntity> exercises;

  @ManyToOne
  @JoinColumn(name = "owner")
  private UserJpaEntity owner;

  private LocalDateTime createdAt;
}

package com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "exercise_types")
public class ExerciseTypeJpaEntity {
  private UUID id;
  private String name;
  private String weightUnit;
  private String distanceUnit;
}

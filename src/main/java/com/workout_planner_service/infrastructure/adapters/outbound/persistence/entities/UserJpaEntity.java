package com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserJpaEntity {
  @Id private UUID id;
  private String name;
}

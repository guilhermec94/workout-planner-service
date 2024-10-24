package com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories;

import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.WorkoutJpaEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutJpaRepository extends JpaRepository<WorkoutJpaEntity, UUID> {
  @Query("SELECT w FROM WorkoutJpaEntity w WHERE w.owner.id = :userId")
  List<WorkoutJpaEntity> getWorkoutsByUserId(@Param("userId") UUID userId);
}

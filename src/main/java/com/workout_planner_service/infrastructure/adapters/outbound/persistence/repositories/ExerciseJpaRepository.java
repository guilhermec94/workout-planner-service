package com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories;

import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.ExerciseJpaEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseJpaRepository extends JpaRepository<ExerciseJpaEntity, UUID> {
  @Query("SELECT ec FROM ExerciseJpaEntity ec WHERE ec.owner.id = :userId")
  List<ExerciseJpaEntity> getExercisesByUserId(@Param("userId") UUID userId);
}

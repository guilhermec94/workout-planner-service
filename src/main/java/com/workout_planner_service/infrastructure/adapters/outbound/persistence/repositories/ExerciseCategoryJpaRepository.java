package com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories;

import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.ExerciseCategoryJpaEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseCategoryJpaRepository
    extends JpaRepository<ExerciseCategoryJpaEntity, UUID> {
  @Query("SELECT ec FROM ExerciseCategoryJpaEntity ec WHERE ec.owner.id = :userId")
  List<ExerciseCategoryJpaEntity> getExerciseCategoriesByUserId(@Param("userId") UUID userId);
}

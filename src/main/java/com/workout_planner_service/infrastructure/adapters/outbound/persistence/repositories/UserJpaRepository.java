package com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories;

import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.UserJpaEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends BaseJpaRepository<UserJpaEntity> {}

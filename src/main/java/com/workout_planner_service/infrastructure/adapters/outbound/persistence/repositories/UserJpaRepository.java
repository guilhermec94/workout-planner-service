package com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories;

import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.UserJpaEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserJpaEntity, UUID> {}

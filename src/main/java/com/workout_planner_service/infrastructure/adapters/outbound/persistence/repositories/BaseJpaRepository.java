package com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseJpaRepository<T> extends JpaRepository<T, UUID> {}

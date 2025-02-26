package com.workout_planner_service.infrastructure.adapters.outbound.persistence;

import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.UserJpaEntity;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers.UserJpaPersistenceMapper;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories.UserJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserPersistenceAdapter extends BasePersistencePortAdapter<User, UserJpaEntity>
    implements UserPersistencePort {

  public UserPersistenceAdapter(
      UserJpaRepository jpaRepository, UserJpaPersistenceMapper jpaPersistenceMapper) {
    super(jpaRepository, jpaPersistenceMapper);
  }
}

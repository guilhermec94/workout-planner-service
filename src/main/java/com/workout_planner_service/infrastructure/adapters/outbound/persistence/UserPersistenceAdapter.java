package com.workout_planner_service.infrastructure.adapters.outbound.persistence;

import com.workout_planner_service.application.ports.outbound.persistence.UserPersistencePort;
import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers.UserJpaPersistenceMapper;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories.UserJpaRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

  private final UserJpaRepository jpaRepository;
  private final UserJpaPersistenceMapper jpaPersistenceMapper;

  @Override
  public Optional<User> GetByID(@NonNull UUID id) {
    var entity = this.jpaRepository.findById(id);
    return entity.map(this.jpaPersistenceMapper::toUser);
  }
}

package com.workout_planner_service.application.ports.outbound;

import com.workout_planner_service.domain.model.User;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;

public interface UserPersistencePort {
  Optional<User> GetByID(@NonNull UUID id);
}

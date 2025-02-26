package com.workout_planner_service.infrastructure.adapters.security;

import com.workout_planner_service.application.ports.security.CurrentUserProvider;
import java.util.UUID;

public class CurrentUserProviderAdapter implements CurrentUserProvider {
  @Override
  public UUID getCurrentUser() {
    // TODO: requires complete implementation
    return UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea");
  }
}

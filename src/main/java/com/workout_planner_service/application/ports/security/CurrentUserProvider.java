package com.workout_planner_service.application.ports.security;

import java.util.UUID;

public interface CurrentUserProvider {
  UUID getCurrentUser();
}

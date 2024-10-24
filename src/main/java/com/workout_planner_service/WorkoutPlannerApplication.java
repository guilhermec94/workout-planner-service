package com.workout_planner_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(
    basePackages = {
      "com.workout_planner_service.infrastructure.adapters.outbound.persistence",
      "com.workout_planner_service.infrastructure.adapters.outbound.persistence.mapper"
    })
@EntityScan(
    basePackages =
        "com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities")
@EnableJpaRepositories(
    basePackages =
        "com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories")
public class WorkoutPlannerApplication {

  public static void main(String[] args) {
    SpringApplication.run(WorkoutPlannerApplication.class, args);
  }
}

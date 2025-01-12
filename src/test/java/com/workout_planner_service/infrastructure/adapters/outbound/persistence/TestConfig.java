package com.workout_planner_service.infrastructure.adapters.outbound.persistence;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration
@SpringBootConfiguration
@ComponentScan(
    basePackages = {
      "com.workout_planner_service.infrastructure.adapters.outbound.persistence",
      "com.workout_planner_service.infrastructure.adapters.outbound.persistence.repositories"
    })
@PropertySource("classpath:application.properties")
public class TestConfig {}

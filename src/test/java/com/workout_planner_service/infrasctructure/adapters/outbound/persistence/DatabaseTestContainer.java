package com.workout_planner_service.infrasctructure.adapters.outbound.persistence;

import static org.testcontainers.containers.PostgreSQLContainer.POSTGRESQL_PORT;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@DataJpaTest
@Testcontainers
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
public abstract class DatabaseTestContainer {

  static final PostgreSQLContainer<?> postgreSQLContainer;

  static {
    postgreSQLContainer =
        new PostgreSQLContainer<>(DockerImageName.parse("library/postgres:17.0"))
            .withStartupTimeout(Duration.of(60, ChronoUnit.SECONDS));
    postgreSQLContainer.start();
  }

  @DynamicPropertySource
  static void overrideProperties(DynamicPropertyRegistry registry) {
    registry.add("database.host.name", postgreSQLContainer::getHost);
    registry.add("database.host.port", () -> postgreSQLContainer.getMappedPort(POSTGRESQL_PORT));
    registry.add("database.user.name", postgreSQLContainer::getUsername);
    registry.add("database.user.pass", postgreSQLContainer::getPassword);
    registry.add("database.name", postgreSQLContainer::getDatabaseName);
  }
}

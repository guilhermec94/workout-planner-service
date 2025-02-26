package com.workout_planner_service.infrastructure.adapters.inbound.rest;

import com.workout_planner_service.application.ports.inbound.ExerciseUseCase;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// TODO: verify all operations against the authenticated user to check if the user is valid and if
// resources belong to him
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ExerciseRestAdapter {
  private final ExerciseUseCase exerciseUseCase;

  @GetMapping(value = "/exercises")
  public List<ExerciseDTO> getAll() {
    return exerciseUseCase.getAllExercises(UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"));
  }

  @GetMapping(value = "/exercises/{id}")
  public Optional<ExerciseDTO> getById(@PathVariable UUID id) {
    return exerciseUseCase.getById(id);
  }

  @PostMapping(value = "/exercises")
  public ExerciseDTO create(@RequestBody ExerciseDTO dto) {
    return exerciseUseCase.createExercise(
        dto, UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"));
  }

  @PatchMapping(value = "/exercises/{id}")
  public void patch(@PathVariable UUID id, @RequestBody ExerciseDTO dto) {
    exerciseUseCase.patchExercise(dto, id, UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"));
  }

  @DeleteMapping(value = "/exercises/{id}")
  public void delete(@PathVariable UUID id) {
    exerciseUseCase.delete(id);
  }
}

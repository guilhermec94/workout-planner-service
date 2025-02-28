package com.workout_planner_service.infrastructure.adapters.inbound.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.workout_planner_service.application.ports.inbound.WorkoutUseCase;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutDTO;
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
public class WorkoutRestAdapter {
  private final WorkoutUseCase workoutUseCase;

  @GetMapping(value = "/workouts")
  public List<WorkoutDTO> getAll() {
    return workoutUseCase.getAllWorkouts(UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"));
  }

  @GetMapping(value = "/workouts/{id}")
  public Optional<WorkoutDTO> getById(@PathVariable UUID id) {
    return workoutUseCase.getById(id);
  }

  @PostMapping(value = "/workouts")
  public WorkoutDTO create(@RequestBody WorkoutDTO dto) {
    return workoutUseCase.createWorkout(
        dto, UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"));
  }

  @PatchMapping(value = "/workouts/{id}")
  public void patch(@PathVariable UUID id, @RequestBody JsonPatch patch)
      throws JsonPatchException, JsonProcessingException {
    workoutUseCase.patchWorkout(patch, id, UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"));
  }

  @DeleteMapping(value = "/workouts/{id}")
  public void delete(@PathVariable UUID id) {
    workoutUseCase.delete(id);
  }
}

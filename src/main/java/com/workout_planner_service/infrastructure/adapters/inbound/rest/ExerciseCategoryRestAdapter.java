package com.workout_planner_service.infrastructure.adapters.inbound.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.workout_planner_service.application.ports.inbound.ExerciseCategoryUseCase;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseCategoryDTO;
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
public class ExerciseCategoryRestAdapter {
  private final ExerciseCategoryUseCase exerciseCategoryUseCase;

  @GetMapping(value = "/exercises/categories")
  public List<ExerciseCategoryDTO> getAll() {
    return exerciseCategoryUseCase.getAllExerciseCategories(
        UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"));
  }

  @GetMapping(value = "/exercises/categories/{id}")
  public Optional<ExerciseCategoryDTO> getById(@PathVariable UUID id) {
    return exerciseCategoryUseCase.getById(id);
  }

  @PostMapping(value = "/exercises/categories")
  public ExerciseCategoryDTO create(@RequestBody ExerciseCategoryDTO dto) {
    return exerciseCategoryUseCase.createExerciseCategory(
        dto, UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"));
  }

  @PatchMapping(value = "/exercises/categories/{id}")
  public void patch(@PathVariable UUID id, @RequestBody JsonPatch patch)
      throws JsonPatchException, JsonProcessingException {
    exerciseCategoryUseCase.patchExerciseCategory(
        patch, id, UUID.fromString("2e97b683-1b68-406d-b101-533c347e67ea"));
  }

  @DeleteMapping(value = "/exercises/categories/{id}")
  public void delete(@PathVariable UUID id) {
    exerciseCategoryUseCase.delete(id);
  }
}

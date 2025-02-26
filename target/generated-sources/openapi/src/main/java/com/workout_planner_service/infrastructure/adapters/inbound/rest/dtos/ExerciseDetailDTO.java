package com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseCategoryDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseTypeDTO;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ExerciseDetailDTO
 */
@lombok.Builder @lombok.Getter

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-26T08:08:05.944939600Z[Europe/Lisbon]", comments = "Generator version: 7.11.0")
public class ExerciseDetailDTO {

  private @Nullable UUID id;

  private @Nullable String name;

  private @Nullable ExerciseCategoryDTO category;

  private @Nullable ExerciseTypeDTO exerciseType;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime createdAt;

  public ExerciseDetailDTO id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier
   * @return id
   */
  @Valid 
  @Schema(name = "id", description = "The unique identifier", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ExerciseDetailDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ExerciseDetailDTO category(ExerciseCategoryDTO category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   */
  @Valid 
  @Schema(name = "category", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("category")
  public ExerciseCategoryDTO getCategory() {
    return category;
  }

  public void setCategory(ExerciseCategoryDTO category) {
    this.category = category;
  }

  public ExerciseDetailDTO exerciseType(ExerciseTypeDTO exerciseType) {
    this.exerciseType = exerciseType;
    return this;
  }

  /**
   * Get exerciseType
   * @return exerciseType
   */
  @Valid 
  @Schema(name = "exerciseType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("exerciseType")
  public ExerciseTypeDTO getExerciseType() {
    return exerciseType;
  }

  public void setExerciseType(ExerciseTypeDTO exerciseType) {
    this.exerciseType = exerciseType;
  }

  public ExerciseDetailDTO createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
   */
  @Valid 
  @Schema(name = "createdAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExerciseDetailDTO exerciseDetailDTO = (ExerciseDetailDTO) o;
    return Objects.equals(this.id, exerciseDetailDTO.id) &&
        Objects.equals(this.name, exerciseDetailDTO.name) &&
        Objects.equals(this.category, exerciseDetailDTO.category) &&
        Objects.equals(this.exerciseType, exerciseDetailDTO.exerciseType) &&
        Objects.equals(this.createdAt, exerciseDetailDTO.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, category, exerciseType, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExerciseDetailDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    exerciseType: ").append(toIndentedString(exerciseType)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


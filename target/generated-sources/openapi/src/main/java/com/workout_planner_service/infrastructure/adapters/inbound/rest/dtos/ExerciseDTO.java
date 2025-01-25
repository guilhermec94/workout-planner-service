package com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ExerciseDTO
 */
@lombok.Builder @lombok.Getter

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-25T15:35:46.008331Z[Europe/Lisbon]", comments = "Generator version: 7.11.0")
public class ExerciseDTO {

  private @Nullable UUID id;

  private @Nullable String name;

  private @Nullable UUID categoryId;

  private @Nullable UUID exerciseTypeId;

  private @Nullable String creationDate;

  public ExerciseDTO id(UUID id) {
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

  public ExerciseDTO name(String name) {
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

  public ExerciseDTO categoryId(UUID categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * The unique identifier
   * @return categoryId
   */
  @Valid 
  @Schema(name = "categoryId", description = "The unique identifier", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categoryId")
  public UUID getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(UUID categoryId) {
    this.categoryId = categoryId;
  }

  public ExerciseDTO exerciseTypeId(UUID exerciseTypeId) {
    this.exerciseTypeId = exerciseTypeId;
    return this;
  }

  /**
   * The unique identifier
   * @return exerciseTypeId
   */
  @Valid 
  @Schema(name = "exerciseTypeId", description = "The unique identifier", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("exerciseTypeId")
  public UUID getExerciseTypeId() {
    return exerciseTypeId;
  }

  public void setExerciseTypeId(UUID exerciseTypeId) {
    this.exerciseTypeId = exerciseTypeId;
  }

  public ExerciseDTO creationDate(String creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Get creationDate
   * @return creationDate
   */
  
  @Schema(name = "creationDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("creationDate")
  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExerciseDTO exerciseDTO = (ExerciseDTO) o;
    return Objects.equals(this.id, exerciseDTO.id) &&
        Objects.equals(this.name, exerciseDTO.name) &&
        Objects.equals(this.categoryId, exerciseDTO.categoryId) &&
        Objects.equals(this.exerciseTypeId, exerciseDTO.exerciseTypeId) &&
        Objects.equals(this.creationDate, exerciseDTO.creationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, categoryId, exerciseTypeId, creationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExerciseDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    exerciseTypeId: ").append(toIndentedString(exerciseTypeId)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
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


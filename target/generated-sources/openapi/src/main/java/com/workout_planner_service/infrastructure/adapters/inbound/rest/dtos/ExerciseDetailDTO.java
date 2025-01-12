package com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.CategoryDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseTypeDTO;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ExerciseDetailDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-11T17:20:05.992941900Z[Europe/Lisbon]", comments = "Generator version: 7.8.0")
public class ExerciseDetailDTO {

  private UUID id;

  private String name;

  private CategoryDTO category;

  private ExerciseTypeDTO exerciseType;

  private String creationDate;

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

  public ExerciseDetailDTO category(CategoryDTO category) {
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
  public CategoryDTO getCategory() {
    return category;
  }

  public void setCategory(CategoryDTO category) {
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

  public ExerciseDetailDTO creationDate(String creationDate) {
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
    ExerciseDetailDTO exerciseDetailDTO = (ExerciseDetailDTO) o;
    return Objects.equals(this.id, exerciseDetailDTO.id) &&
        Objects.equals(this.name, exerciseDetailDTO.name) &&
        Objects.equals(this.category, exerciseDetailDTO.category) &&
        Objects.equals(this.exerciseType, exerciseDetailDTO.exerciseType) &&
        Objects.equals(this.creationDate, exerciseDetailDTO.creationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, category, exerciseType, creationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExerciseDetailDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    exerciseType: ").append(toIndentedString(exerciseType)).append("\n");
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


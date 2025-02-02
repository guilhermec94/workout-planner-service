package com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
import java.math.BigDecimal;
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
 * WorkoutRecordDTO
 */
@lombok.Builder @lombok.Getter

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-02T12:15:38.599883400Z[Europe/Lisbon]", comments = "Generator version: 7.11.0")
public class WorkoutRecordDTO {

  private @Nullable UUID id;

  private @Nullable ExerciseDTO exercise;

  private @Nullable BigDecimal series;

  private @Nullable BigDecimal reps;

  private @Nullable BigDecimal weight;

  private @Nullable BigDecimal distance;

  private @Nullable String time;

  public WorkoutRecordDTO id(UUID id) {
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

  public WorkoutRecordDTO exercise(ExerciseDTO exercise) {
    this.exercise = exercise;
    return this;
  }

  /**
   * Get exercise
   * @return exercise
   */
  @Valid 
  @Schema(name = "exercise", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("exercise")
  public ExerciseDTO getExercise() {
    return exercise;
  }

  public void setExercise(ExerciseDTO exercise) {
    this.exercise = exercise;
  }

  public WorkoutRecordDTO series(BigDecimal series) {
    this.series = series;
    return this;
  }

  /**
   * Get series
   * @return series
   */
  @Valid 
  @Schema(name = "series", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("series")
  public BigDecimal getSeries() {
    return series;
  }

  public void setSeries(BigDecimal series) {
    this.series = series;
  }

  public WorkoutRecordDTO reps(BigDecimal reps) {
    this.reps = reps;
    return this;
  }

  /**
   * Get reps
   * @return reps
   */
  @Valid 
  @Schema(name = "reps", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reps")
  public BigDecimal getReps() {
    return reps;
  }

  public void setReps(BigDecimal reps) {
    this.reps = reps;
  }

  public WorkoutRecordDTO weight(BigDecimal weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Get weight
   * @return weight
   */
  @Valid 
  @Schema(name = "weight", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("weight")
  public BigDecimal getWeight() {
    return weight;
  }

  public void setWeight(BigDecimal weight) {
    this.weight = weight;
  }

  public WorkoutRecordDTO distance(BigDecimal distance) {
    this.distance = distance;
    return this;
  }

  /**
   * Get distance
   * @return distance
   */
  @Valid 
  @Schema(name = "distance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distance")
  public BigDecimal getDistance() {
    return distance;
  }

  public void setDistance(BigDecimal distance) {
    this.distance = distance;
  }

  public WorkoutRecordDTO time(String time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
   */
  
  @Schema(name = "time", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("time")
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkoutRecordDTO workoutRecordDTO = (WorkoutRecordDTO) o;
    return Objects.equals(this.id, workoutRecordDTO.id) &&
        Objects.equals(this.exercise, workoutRecordDTO.exercise) &&
        Objects.equals(this.series, workoutRecordDTO.series) &&
        Objects.equals(this.reps, workoutRecordDTO.reps) &&
        Objects.equals(this.weight, workoutRecordDTO.weight) &&
        Objects.equals(this.distance, workoutRecordDTO.distance) &&
        Objects.equals(this.time, workoutRecordDTO.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, exercise, series, reps, weight, distance, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkoutRecordDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    exercise: ").append(toIndentedString(exercise)).append("\n");
    sb.append("    series: ").append(toIndentedString(series)).append("\n");
    sb.append("    reps: ").append(toIndentedString(reps)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
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


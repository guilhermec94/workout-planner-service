package com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.PaginationDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutRecordDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * WorkoutRecordsDTO
 */
@lombok.Builder @lombok.Getter

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-02T12:15:38.599883400Z[Europe/Lisbon]", comments = "Generator version: 7.11.0")
public class WorkoutRecordsDTO {

  @lombok.Builder.Default
  @Valid
  private List<@Valid WorkoutRecordDTO> data = new ArrayList<>();

  private @Nullable PaginationDTO pagination;

  public WorkoutRecordsDTO data(List<@Valid WorkoutRecordDTO> data) {
    this.data = data;
    return this;
  }

  public WorkoutRecordsDTO addDataItem(WorkoutRecordDTO dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
   */
  @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("data")
  public List<@Valid WorkoutRecordDTO> getData() {
    return data;
  }

  public void setData(List<@Valid WorkoutRecordDTO> data) {
    this.data = data;
  }

  public WorkoutRecordsDTO pagination(PaginationDTO pagination) {
    this.pagination = pagination;
    return this;
  }

  /**
   * Get pagination
   * @return pagination
   */
  @Valid 
  @Schema(name = "pagination", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pagination")
  public PaginationDTO getPagination() {
    return pagination;
  }

  public void setPagination(PaginationDTO pagination) {
    this.pagination = pagination;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkoutRecordsDTO workoutRecordsDTO = (WorkoutRecordsDTO) o;
    return Objects.equals(this.data, workoutRecordsDTO.data) &&
        Objects.equals(this.pagination, workoutRecordsDTO.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, pagination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkoutRecordsDTO {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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


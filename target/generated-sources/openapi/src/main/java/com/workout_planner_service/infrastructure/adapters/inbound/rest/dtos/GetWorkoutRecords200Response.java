package com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.PaginationDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutRecordDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * GetWorkoutRecords200Response
 */

@JsonTypeName("GetWorkoutRecords_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-11T17:20:05.992941900Z[Europe/Lisbon]", comments = "Generator version: 7.8.0")
public class GetWorkoutRecords200Response {

  @Valid
  private List<@Valid WorkoutRecordDTO> data = new ArrayList<>();

  private PaginationDTO pagination;

  public GetWorkoutRecords200Response() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GetWorkoutRecords200Response(List<@Valid WorkoutRecordDTO> data, PaginationDTO pagination) {
    this.data = data;
    this.pagination = pagination;
  }

  public GetWorkoutRecords200Response data(List<@Valid WorkoutRecordDTO> data) {
    this.data = data;
    return this;
  }

  public GetWorkoutRecords200Response addDataItem(WorkoutRecordDTO dataItem) {
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
  @NotNull @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public List<@Valid WorkoutRecordDTO> getData() {
    return data;
  }

  public void setData(List<@Valid WorkoutRecordDTO> data) {
    this.data = data;
  }

  public GetWorkoutRecords200Response pagination(PaginationDTO pagination) {
    this.pagination = pagination;
    return this;
  }

  /**
   * Get pagination
   * @return pagination
   */
  @NotNull @Valid 
  @Schema(name = "pagination", requiredMode = Schema.RequiredMode.REQUIRED)
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
    GetWorkoutRecords200Response getWorkoutRecords200Response = (GetWorkoutRecords200Response) o;
    return Objects.equals(this.data, getWorkoutRecords200Response.data) &&
        Objects.equals(this.pagination, getWorkoutRecords200Response.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, pagination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetWorkoutRecords200Response {\n");
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


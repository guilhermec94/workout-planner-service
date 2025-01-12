package com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.PaginationDTO;
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
 * GetExerciseInstructions200Response
 */

@JsonTypeName("GetExerciseInstructions_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-11T17:20:05.992941900Z[Europe/Lisbon]", comments = "Generator version: 7.8.0")
public class GetExerciseInstructions200Response {

  @Valid
  private List<@Valid ExerciseDTO> data = new ArrayList<>();

  private PaginationDTO pagination;

  public GetExerciseInstructions200Response() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GetExerciseInstructions200Response(List<@Valid ExerciseDTO> data, PaginationDTO pagination) {
    this.data = data;
    this.pagination = pagination;
  }

  public GetExerciseInstructions200Response data(List<@Valid ExerciseDTO> data) {
    this.data = data;
    return this;
  }

  public GetExerciseInstructions200Response addDataItem(ExerciseDTO dataItem) {
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
  public List<@Valid ExerciseDTO> getData() {
    return data;
  }

  public void setData(List<@Valid ExerciseDTO> data) {
    this.data = data;
  }

  public GetExerciseInstructions200Response pagination(PaginationDTO pagination) {
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
    GetExerciseInstructions200Response getExerciseInstructions200Response = (GetExerciseInstructions200Response) o;
    return Objects.equals(this.data, getExerciseInstructions200Response.data) &&
        Objects.equals(this.pagination, getExerciseInstructions200Response.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, pagination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetExerciseInstructions200Response {\n");
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


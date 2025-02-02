package com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets SortOrderDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-02T14:38:13.964736100Z[Europe/Lisbon]", comments = "Generator version: 7.11.0")
public enum SortOrderDTO {
  
  ASC("ASC"),
  
  DESC("DESC");

  private String value;

  SortOrderDTO(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static SortOrderDTO fromValue(String value) {
    for (SortOrderDTO b : SortOrderDTO.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


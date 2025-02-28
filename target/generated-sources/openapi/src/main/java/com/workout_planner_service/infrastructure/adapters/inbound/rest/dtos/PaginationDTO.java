package com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PaginationDTO
 */
@lombok.Builder @lombok.Getter

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-27T15:09:49.411941100Z[Europe/Lisbon]", comments = "Generator version: 7.11.0")
public class PaginationDTO {

  private @Nullable Integer page;

  private @Nullable Integer perPage;

  private @Nullable Integer totalRecords;

  public PaginationDTO page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Get page
   * @return page
   */
  
  @Schema(name = "page", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("page")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public PaginationDTO perPage(Integer perPage) {
    this.perPage = perPage;
    return this;
  }

  /**
   * Get perPage
   * @return perPage
   */
  
  @Schema(name = "per_page", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("per_page")
  public Integer getPerPage() {
    return perPage;
  }

  public void setPerPage(Integer perPage) {
    this.perPage = perPage;
  }

  public PaginationDTO totalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
    return this;
  }

  /**
   * Get totalRecords
   * @return totalRecords
   */
  
  @Schema(name = "total_records", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total_records")
  public Integer getTotalRecords() {
    return totalRecords;
  }

  public void setTotalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginationDTO paginationDTO = (PaginationDTO) o;
    return Objects.equals(this.page, paginationDTO.page) &&
        Objects.equals(this.perPage, paginationDTO.perPage) &&
        Objects.equals(this.totalRecords, paginationDTO.totalRecords);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, perPage, totalRecords);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginationDTO {\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    perPage: ").append(toIndentedString(perPage)).append("\n");
    sb.append("    totalRecords: ").append(toIndentedString(totalRecords)).append("\n");
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


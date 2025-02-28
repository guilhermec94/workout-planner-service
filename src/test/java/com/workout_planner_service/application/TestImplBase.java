package com.workout_planner_service.application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.diff.JsonDiff;

public abstract class TestImplBase<T> {
  private final ObjectMapper objectMapper =
      new ObjectMapper()
          .registerModule(new JavaTimeModule())
          .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

  JsonPatch generatePatch(T original, T updated) {
    JsonNode originalNode = objectMapper.convertValue(original, JsonNode.class);
    JsonNode updatedNode = objectMapper.convertValue(updated, JsonNode.class);

    return JsonDiff.asJsonPatch(originalNode, updatedNode);
  }
}

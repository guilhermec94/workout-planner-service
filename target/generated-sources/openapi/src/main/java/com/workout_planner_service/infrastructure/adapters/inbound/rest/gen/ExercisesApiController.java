package com.workout_planner_service.infrastructure.adapters.inbound.rest.gen;

import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.CategoryDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ErrorDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseInstructionDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseTypeDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.GetExerciseInstructions200Response;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.SortOrderDTO;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-11T17:20:05.992941900Z[Europe/Lisbon]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.workoutPlanner.base-path:/api/v1}")
public class ExercisesApiController implements ExercisesApi {

    private final ExercisesApiDelegate delegate;

    public ExercisesApiController(@Autowired(required = false) ExercisesApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ExercisesApiDelegate() {});
    }

    @Override
    public ExercisesApiDelegate getDelegate() {
        return delegate;
    }

}

package com.workout_planner_service.infrastructure.adapters.inbound.rest.gen;

import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ErrorDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.GetWorkoutRecords200Response;
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
public class WorkoutApiController implements WorkoutApi {

    private final WorkoutApiDelegate delegate;

    public WorkoutApiController(@Autowired(required = false) WorkoutApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new WorkoutApiDelegate() {});
    }

    @Override
    public WorkoutApiDelegate getDelegate() {
        return delegate;
    }

}

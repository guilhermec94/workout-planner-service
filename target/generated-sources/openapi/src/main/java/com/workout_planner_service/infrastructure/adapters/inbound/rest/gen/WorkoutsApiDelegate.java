package com.workout_planner_service.infrastructure.adapters.inbound.rest.gen;

import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ErrorDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.GetWorkouts200Response;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.SortOrderDTO;
import java.util.UUID;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.WorkoutDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link WorkoutsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-11T17:20:05.992941900Z[Europe/Lisbon]", comments = "Generator version: 7.8.0")
public interface WorkoutsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /workouts : Create a new workout
     *
     * @param workoutDTO Workout payload (optional)
     * @return The newly created workout (status code 201)
     *         or Unexpected error (status code 500)
     * @see WorkoutsApi#createWorkout
     */
    default ResponseEntity<Void> createWorkout(WorkoutDTO workoutDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /workouts/{workoutId} : Delete a workout by id
     *
     * @param workoutId The unique identifier (required)
     * @return Success deleting a workout (status code 200)
     *         or No workout found for the provided &#x60;workoutId&#x60; (status code 404)
     *         or Unexpected error (status code 500)
     * @see WorkoutsApi#deleteWorkout
     */
    default ResponseEntity<Void> deleteWorkout(UUID workoutId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /workouts/{workoutId} : Get a workout by id
     *
     * @param workoutId The unique identifier (required)
     * @return A workout (status code 200)
     * @see WorkoutsApi#getWorkout
     */
    default ResponseEntity<WorkoutDTO> getWorkout(UUID workoutId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"creationDate\" : \"creationDate\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /workouts : Fetch a list of workouts
     *
     * @param offset The number of items to skip before starting to collect the result set (optional)
     * @param limit The numbers of items to return (optional)
     * @param filterKey name of the field to filter by (optional)
     * @param filterValue value of the field to filter with (optional)
     * @param sortKey  (optional)
     * @param sortOrder  (optional)
     * @return A list of workouts (status code 200)
     *         or Unexpected error (status code 500)
     * @see WorkoutsApi#getWorkouts
     */
    default ResponseEntity<GetWorkouts200Response> getWorkouts(Integer offset,
        Integer limit,
        List<String> filterKey,
        List<String> filterValue,
        String sortKey,
        SortOrderDTO sortOrder) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"pagination\" : { \"per_page\" : 6, \"total_records\" : 1, \"page\" : 0 }, \"data\" : [ { \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"creationDate\" : \"creationDate\" }, { \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"creationDate\" : \"creationDate\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PATCH /workouts/{workoutId} : Patch a workout
     * Body schema should follow format RFC 6902 (application/json-patch+json)
     *
     * @param workoutId The unique identifier (required)
     * @param body  (optional)
     * @return Success patching a workout (status code 200)
     *         or No workout found for the provided &#x60;workoutId&#x60; (status code 404)
     *         or Conflict detected during update (status code 409)
     *         or Unexpected error (status code 500)
     * @see WorkoutsApi#patchWorkout
     */
    default ResponseEntity<Void> patchWorkout(UUID workoutId,
        Object body) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}

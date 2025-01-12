package com.workout_planner_service.infrastructure.adapters.inbound.rest.gen;

import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ErrorDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.GetWorkoutRecords200Response;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.SortOrderDTO;
import java.util.UUID;
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
 * A delegate to be called by the {@link WorkoutApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-11T17:20:05.992941900Z[Europe/Lisbon]", comments = "Generator version: 7.8.0")
public interface WorkoutApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /workout/{workoutId}/records : Fetch a list of workout records
     *
     * @param workoutId The unique identifier (required)
     * @param offset The number of items to skip before starting to collect the result set (optional)
     * @param limit The numbers of items to return (optional)
     * @param filterKey name of the field to filter by (optional)
     * @param filterValue value of the field to filter with (optional)
     * @param sortKey  (optional)
     * @param sortOrder  (optional)
     * @return A list of workout records (status code 200)
     *         or Unexpected error (status code 500)
     * @see WorkoutApi#getWorkoutRecords
     */
    default ResponseEntity<GetWorkoutRecords200Response> getWorkoutRecords(UUID workoutId,
        Integer offset,
        Integer limit,
        List<String> filterKey,
        List<String> filterValue,
        String sortKey,
        SortOrderDTO sortOrder) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"pagination\" : { \"per_page\" : 6, \"total_records\" : 1, \"page\" : 0 }, \"data\" : [ { \"reps\" : 6.027456183070403, \"distance\" : 5.962133916683182, \"series\" : 0.8008281904610115, \"exercise\" : { \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"creationDate\" : \"creationDate\", \"categoryId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"exerciseTypeId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, \"weight\" : 1.4658129805029452, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"time\" : \"time\" }, { \"reps\" : 6.027456183070403, \"distance\" : 5.962133916683182, \"series\" : 0.8008281904610115, \"exercise\" : { \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"creationDate\" : \"creationDate\", \"categoryId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"exerciseTypeId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, \"weight\" : 1.4658129805029452, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"time\" : \"time\" } ] }";
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

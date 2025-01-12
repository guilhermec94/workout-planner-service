package com.workout_planner_service.infrastructure.adapters.inbound.rest.gen;

import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.CategoryDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ErrorDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseInstructionDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.ExerciseTypeDTO;
import com.workout_planner_service.infrastructure.adapters.inbound.rest.dtos.GetExerciseInstructions200Response;
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
 * A delegate to be called by the {@link ExercisesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-11T17:20:05.992941900Z[Europe/Lisbon]", comments = "Generator version: 7.8.0")
public interface ExercisesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /exercises/categories : Create a new category
     *
     * @param categoryDTO Category payload (optional)
     * @return The newly created category (status code 201)
     *         or Unexpected error (status code 500)
     * @see ExercisesApi#createCategory
     */
    default ResponseEntity<Void> createCategory(CategoryDTO categoryDTO) {
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
     * POST /exercises : Create a new exercise
     *
     * @param exerciseDTO Exercise payload (optional)
     * @return The newly created exercise (status code 201)
     *         or Unexpected error (status code 500)
     * @see ExercisesApi#createExercise
     */
    default ResponseEntity<Void> createExercise(ExerciseDTO exerciseDTO) {
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
     * POST /exercises/{exerciseId}/instructions : Create a new exercise instruction
     *
     * @param exerciseId The unique identifier (required)
     * @param exerciseInstructionDTO Exercise instruction payload (optional)
     * @return The newly created exercise instruction (status code 201)
     *         or Unexpected error (status code 500)
     * @see ExercisesApi#createExerciseInstruction
     */
    default ResponseEntity<Void> createExerciseInstruction(UUID exerciseId,
        ExerciseInstructionDTO exerciseInstructionDTO) {
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
     * DELETE /exercises/categories/{categoryId} : Delete a category by id
     *
     * @param categoryId The unique identifier (required)
     * @return Success deleting a category (status code 200)
     *         or No category found for the provided &#x60;categoryId&#x60; (status code 404)
     *         or Unexpected error (status code 500)
     * @see ExercisesApi#deleteCategory
     */
    default ResponseEntity<Void> deleteCategory(UUID categoryId) {
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
     * DELETE /exercises/{exerciseId} : Delete a exercise by id
     *
     * @param exerciseId The unique identifier (required)
     * @return Success deleting a exercise (status code 200)
     *         or No exercise found for the provided &#x60;exerciseId&#x60; (status code 404)
     *         or Unexpected error (status code 500)
     * @see ExercisesApi#deleteExercise
     */
    default ResponseEntity<Void> deleteExercise(UUID exerciseId) {
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
     * DELETE /exercises/{exerciseId}/instructions/{instructionId} : Delete a exercise instruction by id
     *
     * @param exerciseId The unique identifier (required)
     * @param instructionId The unique identifier (required)
     * @return Success deleting a exercise instruction (status code 200)
     *         or No exercise found for the provided &#x60;exerciseId&#x60; (status code 404)
     *         or Unexpected error (status code 500)
     * @see ExercisesApi#deleteExerciseInstruction
     */
    default ResponseEntity<Void> deleteExerciseInstruction(UUID exerciseId,
        UUID instructionId) {
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
     * GET /exercises/categories : Fetch a list of categories
     *
     * @return A list of categories (status code 200)
     *         or Unexpected error (status code 500)
     * @see ExercisesApi#getCategories
     */
    default ResponseEntity<List<CategoryDTO>> getCategories() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ]";
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
     * GET /exercises/categories/{categoryId} : Get a category by id
     *
     * @param categoryId The unique identifier (required)
     * @return A category (status code 200)
     * @see ExercisesApi#getCategory
     */
    default ResponseEntity<ExerciseDTO> getCategory(UUID categoryId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"creationDate\" : \"creationDate\", \"categoryId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"exerciseTypeId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /exercises/{exerciseId} : Get a exercise by id
     *
     * @param exerciseId The unique identifier (required)
     * @return A exercise (status code 200)
     * @see ExercisesApi#getExercise
     */
    default ResponseEntity<ExerciseDTO> getExercise(UUID exerciseId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"creationDate\" : \"creationDate\", \"categoryId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"exerciseTypeId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /exercises/{exerciseId}/instructions/{instructionId} : Get a exercise instruction by id
     *
     * @param exerciseId The unique identifier (required)
     * @param instructionId The unique identifier (required)
     * @return A exercise (status code 200)
     * @see ExercisesApi#getExerciseInstruction
     */
    default ResponseEntity<ExerciseDTO> getExerciseInstruction(UUID exerciseId,
        UUID instructionId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"creationDate\" : \"creationDate\", \"categoryId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"exerciseTypeId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /exercises/{exerciseId}/instructions : Fetch a list of exercises
     *
     * @param exerciseId The unique identifier (required)
     * @return A list of exercises (status code 200)
     *         or Unexpected error (status code 500)
     * @see ExercisesApi#getExerciseInstructions
     */
    default ResponseEntity<GetExerciseInstructions200Response> getExerciseInstructions(UUID exerciseId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"pagination\" : { \"per_page\" : 6, \"total_records\" : 1, \"page\" : 0 }, \"data\" : [ { \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"creationDate\" : \"creationDate\", \"categoryId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"exerciseTypeId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"creationDate\" : \"creationDate\", \"categoryId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"exerciseTypeId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ] }";
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
     * GET /exercises/types : Fetch a list of exercise types
     *
     * @return A list of exercise types (status code 200)
     *         or Unexpected error (status code 500)
     * @see ExercisesApi#getExerciseTypes
     */
    default ResponseEntity<List<ExerciseTypeDTO>> getExerciseTypes() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ]";
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
     * GET /exercises : Fetch a list of exercises
     *
     * @param offset The number of items to skip before starting to collect the result set (optional)
     * @param limit The numbers of items to return (optional)
     * @param filterKey name of the field to filter by (optional)
     * @param filterValue value of the field to filter with (optional)
     * @param sortKey  (optional)
     * @param sortOrder  (optional)
     * @return A list of exercises (status code 200)
     *         or Unexpected error (status code 500)
     * @see ExercisesApi#getExercises
     */
    default ResponseEntity<GetExerciseInstructions200Response> getExercises(Integer offset,
        Integer limit,
        List<String> filterKey,
        List<String> filterValue,
        String sortKey,
        SortOrderDTO sortOrder) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"pagination\" : { \"per_page\" : 6, \"total_records\" : 1, \"page\" : 0 }, \"data\" : [ { \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"creationDate\" : \"creationDate\", \"categoryId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"exerciseTypeId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"creationDate\" : \"creationDate\", \"categoryId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"exerciseTypeId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ] }";
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
     * PATCH /exercises/categories/{categoryId} : Patch a category
     * Body schema should follow format RFC 6902 (application/json-patch+json)
     *
     * @param categoryId The unique identifier (required)
     * @param body  (optional)
     * @return Success patching a category (status code 200)
     *         or No category found for the provided &#x60;categoryId&#x60; (status code 404)
     *         or Conflict detected during update (status code 409)
     *         or Unexpected error (status code 500)
     * @see ExercisesApi#patchCategory
     */
    default ResponseEntity<Void> patchCategory(UUID categoryId,
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

    /**
     * PATCH /exercises/{exerciseId} : Patch a exercise
     * Body schema should follow format RFC 6902 (application/json-patch+json)
     *
     * @param exerciseId The unique identifier (required)
     * @param body  (optional)
     * @return Success patching a exercise (status code 200)
     *         or No exercise found for the provided &#x60;exerciseId&#x60; (status code 404)
     *         or Conflict detected during update (status code 409)
     *         or Unexpected error (status code 500)
     * @see ExercisesApi#patchExercise
     */
    default ResponseEntity<Void> patchExercise(UUID exerciseId,
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

    /**
     * PATCH /exercises/{exerciseId}/instructions/{instructionId} : Patch a exercise instruction
     * Body schema should follow format RFC 6902 (application/json-patch+json)
     *
     * @param exerciseId The unique identifier (required)
     * @param instructionId The unique identifier (required)
     * @param body  (optional)
     * @return Success patching a exercise (status code 200)
     *         or No exercise found for the provided &#x60;exerciseId&#x60; (status code 404)
     *         or Conflict detected during update (status code 409)
     *         or Unexpected error (status code 500)
     * @see ExercisesApi#patchExerciseInstruction
     */
    default ResponseEntity<Void> patchExerciseInstruction(UUID exerciseId,
        UUID instructionId,
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

package com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers;

import com.workout_planner_service.domain.model.Exercise;
import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.domain.model.ExerciseType;
import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.ExerciseCategoryJpaEntity;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.ExerciseJpaEntity;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.ExerciseTypeJpaEntity;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.UserJpaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-02T14:38:17+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class ExerciseJpaPersistenceMapperImpl implements ExerciseJpaPersistenceMapper {

    @Override
    public ExerciseJpaEntity toExerciseJpaEntity(Exercise exercise) {
        if ( exercise == null ) {
            return null;
        }

        ExerciseJpaEntity.ExerciseJpaEntityBuilder exerciseJpaEntity = ExerciseJpaEntity.builder();

        exerciseJpaEntity.id( exercise.getId() );
        exerciseJpaEntity.name( exercise.getName() );
        exerciseJpaEntity.category( exerciseCategoryToExerciseCategoryJpaEntity( exercise.getCategory() ) );
        exerciseJpaEntity.type( exerciseTypeToExerciseTypeJpaEntity( exercise.getType() ) );
        exerciseJpaEntity.owner( userToUserJpaEntity( exercise.getOwner() ) );
        exerciseJpaEntity.createdAt( exercise.getCreatedAt() );

        return exerciseJpaEntity.build();
    }

    @Override
    public Exercise toExercise(ExerciseJpaEntity exercise) {
        if ( exercise == null ) {
            return null;
        }

        Exercise.ExerciseBuilder exercise1 = Exercise.builder();

        exercise1.id( exercise.getId() );
        exercise1.name( exercise.getName() );
        exercise1.category( exerciseCategoryJpaEntityToExerciseCategory( exercise.getCategory() ) );
        exercise1.type( exerciseTypeJpaEntityToExerciseType( exercise.getType() ) );
        exercise1.owner( userJpaEntityToUser( exercise.getOwner() ) );
        exercise1.createdAt( exercise.getCreatedAt() );

        return exercise1.build();
    }

    protected UserJpaEntity userToUserJpaEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserJpaEntity.UserJpaEntityBuilder userJpaEntity = UserJpaEntity.builder();

        userJpaEntity.id( user.getId() );
        userJpaEntity.firstName( user.getFirstName() );
        userJpaEntity.lastName( user.getLastName() );
        userJpaEntity.email( user.getEmail() );

        return userJpaEntity.build();
    }

    protected ExerciseCategoryJpaEntity exerciseCategoryToExerciseCategoryJpaEntity(ExerciseCategory exerciseCategory) {
        if ( exerciseCategory == null ) {
            return null;
        }

        ExerciseCategoryJpaEntity.ExerciseCategoryJpaEntityBuilder exerciseCategoryJpaEntity = ExerciseCategoryJpaEntity.builder();

        exerciseCategoryJpaEntity.id( exerciseCategory.getId() );
        exerciseCategoryJpaEntity.name( exerciseCategory.getName() );
        exerciseCategoryJpaEntity.owner( userToUserJpaEntity( exerciseCategory.getOwner() ) );
        exerciseCategoryJpaEntity.createdAt( exerciseCategory.getCreatedAt() );

        return exerciseCategoryJpaEntity.build();
    }

    protected ExerciseTypeJpaEntity exerciseTypeToExerciseTypeJpaEntity(ExerciseType exerciseType) {
        if ( exerciseType == null ) {
            return null;
        }

        ExerciseTypeJpaEntity.ExerciseTypeJpaEntityBuilder exerciseTypeJpaEntity = ExerciseTypeJpaEntity.builder();

        exerciseTypeJpaEntity.id( exerciseType.getId() );
        exerciseTypeJpaEntity.name( exerciseType.getName() );
        exerciseTypeJpaEntity.weightUnit( exerciseType.getWeightUnit() );
        exerciseTypeJpaEntity.distanceUnit( exerciseType.getDistanceUnit() );

        return exerciseTypeJpaEntity.build();
    }

    protected User userJpaEntityToUser(UserJpaEntity userJpaEntity) {
        if ( userJpaEntity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userJpaEntity.getId() );
        user.firstName( userJpaEntity.getFirstName() );
        user.lastName( userJpaEntity.getLastName() );
        user.email( userJpaEntity.getEmail() );

        return user.build();
    }

    protected ExerciseCategory exerciseCategoryJpaEntityToExerciseCategory(ExerciseCategoryJpaEntity exerciseCategoryJpaEntity) {
        if ( exerciseCategoryJpaEntity == null ) {
            return null;
        }

        ExerciseCategory.ExerciseCategoryBuilder exerciseCategory = ExerciseCategory.builder();

        exerciseCategory.id( exerciseCategoryJpaEntity.getId() );
        exerciseCategory.name( exerciseCategoryJpaEntity.getName() );
        exerciseCategory.owner( userJpaEntityToUser( exerciseCategoryJpaEntity.getOwner() ) );
        exerciseCategory.createdAt( exerciseCategoryJpaEntity.getCreatedAt() );

        return exerciseCategory.build();
    }

    protected ExerciseType exerciseTypeJpaEntityToExerciseType(ExerciseTypeJpaEntity exerciseTypeJpaEntity) {
        if ( exerciseTypeJpaEntity == null ) {
            return null;
        }

        ExerciseType.ExerciseTypeBuilder exerciseType = ExerciseType.builder();

        exerciseType.id( exerciseTypeJpaEntity.getId() );
        exerciseType.name( exerciseTypeJpaEntity.getName() );
        exerciseType.weightUnit( exerciseTypeJpaEntity.getWeightUnit() );
        exerciseType.distanceUnit( exerciseTypeJpaEntity.getDistanceUnit() );

        return exerciseType.build();
    }
}

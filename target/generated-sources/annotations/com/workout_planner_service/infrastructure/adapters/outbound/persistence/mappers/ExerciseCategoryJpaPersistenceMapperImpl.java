package com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers;

import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.ExerciseCategoryJpaEntity;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.UserJpaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-02T14:38:17+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class ExerciseCategoryJpaPersistenceMapperImpl implements ExerciseCategoryJpaPersistenceMapper {

    @Override
    public ExerciseCategoryJpaEntity toExerciseCategoryJpaEntity(ExerciseCategory exerciseCategory) {
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

    @Override
    public ExerciseCategory toExerciseCategory(ExerciseCategoryJpaEntity exerciseCategory) {
        if ( exerciseCategory == null ) {
            return null;
        }

        ExerciseCategory.ExerciseCategoryBuilder exerciseCategory1 = ExerciseCategory.builder();

        exerciseCategory1.id( exerciseCategory.getId() );
        exerciseCategory1.name( exerciseCategory.getName() );
        exerciseCategory1.owner( userJpaEntityToUser( exerciseCategory.getOwner() ) );
        exerciseCategory1.createdAt( exerciseCategory.getCreatedAt() );

        return exerciseCategory1.build();
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
}

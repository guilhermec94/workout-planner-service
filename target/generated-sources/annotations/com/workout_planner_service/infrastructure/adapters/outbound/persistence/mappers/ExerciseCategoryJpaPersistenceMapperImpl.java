package com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers;

import com.workout_planner_service.domain.model.ExerciseCategory;
import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.ExerciseCategoryJpaEntity;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.UserJpaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-27T15:33:45+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class ExerciseCategoryJpaPersistenceMapperImpl implements ExerciseCategoryJpaPersistenceMapper {

    @Override
    public ExerciseCategoryJpaEntity toJpaEntity(ExerciseCategory model) {
        if ( model == null ) {
            return null;
        }

        ExerciseCategoryJpaEntity.ExerciseCategoryJpaEntityBuilder exerciseCategoryJpaEntity = ExerciseCategoryJpaEntity.builder();

        exerciseCategoryJpaEntity.id( model.getId() );
        exerciseCategoryJpaEntity.name( model.getName() );
        exerciseCategoryJpaEntity.owner( userToUserJpaEntity( model.getOwner() ) );
        exerciseCategoryJpaEntity.createdAt( model.getCreatedAt() );

        return exerciseCategoryJpaEntity.build();
    }

    @Override
    public ExerciseCategory toModel(ExerciseCategoryJpaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ExerciseCategory.ExerciseCategoryBuilder exerciseCategory = ExerciseCategory.builder();

        exerciseCategory.id( entity.getId() );
        exerciseCategory.name( entity.getName() );
        exerciseCategory.owner( userJpaEntityToUser( entity.getOwner() ) );
        exerciseCategory.createdAt( entity.getCreatedAt() );

        return exerciseCategory.build();
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

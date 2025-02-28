package com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers;

import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.domain.model.Workout;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.UserJpaEntity;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.WorkoutJpaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-27T15:33:45+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class WorkoutJpaPersistenceMapperImpl implements WorkoutJpaPersistenceMapper {

    @Override
    public WorkoutJpaEntity toJpaEntity(Workout model) {
        if ( model == null ) {
            return null;
        }

        WorkoutJpaEntity.WorkoutJpaEntityBuilder workoutJpaEntity = WorkoutJpaEntity.builder();

        workoutJpaEntity.id( model.getId() );
        workoutJpaEntity.name( model.getName() );
        workoutJpaEntity.owner( userToUserJpaEntity( model.getOwner() ) );
        workoutJpaEntity.createdAt( model.getCreatedAt() );

        return workoutJpaEntity.build();
    }

    @Override
    public Workout toModel(WorkoutJpaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Workout.WorkoutBuilder workout = Workout.builder();

        workout.id( entity.getId() );
        workout.name( entity.getName() );
        workout.owner( userJpaEntityToUser( entity.getOwner() ) );
        workout.createdAt( entity.getCreatedAt() );

        return workout.build();
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

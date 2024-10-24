package com.workout_planner_service.infrastructure.adapters.outbound.persistence.mapper;

import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.domain.model.Workout;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.UserJpaEntity;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.WorkoutJpaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-24T21:32:25+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class WorkoutJpaPersistenceMapperImpl implements WorkoutJpaPersistenceMapper {

    @Override
    public WorkoutJpaEntity toWorkoutEntity(Workout workout) {
        if ( workout == null ) {
            return null;
        }

        WorkoutJpaEntity.WorkoutJpaEntityBuilder workoutJpaEntity = WorkoutJpaEntity.builder();

        workoutJpaEntity.id( workout.getId() );
        workoutJpaEntity.name( workout.getName() );
        workoutJpaEntity.owner( userToUserJpaEntity( workout.getOwner() ) );
        workoutJpaEntity.createdAt( workout.getCreatedAt() );

        return workoutJpaEntity.build();
    }

    @Override
    public Workout toWorkout(WorkoutJpaEntity workout) {
        if ( workout == null ) {
            return null;
        }

        Workout.WorkoutBuilder workout1 = Workout.builder();

        workout1.id( workout.getId() );
        workout1.name( workout.getName() );
        workout1.owner( userJpaEntityToUser( workout.getOwner() ) );
        workout1.createdAt( workout.getCreatedAt() );

        return workout1.build();
    }

    protected UserJpaEntity userToUserJpaEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserJpaEntity.UserJpaEntityBuilder userJpaEntity = UserJpaEntity.builder();

        userJpaEntity.id( user.getId() );
        userJpaEntity.name( user.getName() );

        return userJpaEntity.build();
    }

    protected User userJpaEntityToUser(UserJpaEntity userJpaEntity) {
        if ( userJpaEntity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userJpaEntity.getId() );
        user.name( userJpaEntity.getName() );

        return user.build();
    }
}

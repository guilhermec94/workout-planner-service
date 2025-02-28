package com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers;

import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.UserJpaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-27T15:33:45+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class UserJpaPersistenceMapperImpl implements UserJpaPersistenceMapper {

    @Override
    public UserJpaEntity toJpaEntity(User model) {
        if ( model == null ) {
            return null;
        }

        UserJpaEntity.UserJpaEntityBuilder userJpaEntity = UserJpaEntity.builder();

        userJpaEntity.id( model.getId() );
        userJpaEntity.firstName( model.getFirstName() );
        userJpaEntity.lastName( model.getLastName() );
        userJpaEntity.email( model.getEmail() );

        return userJpaEntity.build();
    }

    @Override
    public User toModel(UserJpaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( entity.getId() );
        user.firstName( entity.getFirstName() );
        user.lastName( entity.getLastName() );
        user.email( entity.getEmail() );

        return user.build();
    }
}

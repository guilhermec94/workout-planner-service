package com.workout_planner_service.infrastructure.adapters.outbound.persistence.mappers;

import com.workout_planner_service.domain.model.User;
import com.workout_planner_service.infrastructure.adapters.outbound.persistence.entities.UserJpaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-02T14:38:17+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class UserJpaPersistenceMapperImpl implements UserJpaPersistenceMapper {

    @Override
    public UserJpaEntity toUserJpaEntity(User user) {
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

    @Override
    public User toUser(UserJpaEntity user) {
        if ( user == null ) {
            return null;
        }

        User.UserBuilder user1 = User.builder();

        user1.id( user.getId() );
        user1.firstName( user.getFirstName() );
        user1.lastName( user.getLastName() );
        user1.email( user.getEmail() );

        return user1.build();
    }
}

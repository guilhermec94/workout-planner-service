package com.workout_planner_service.domain.model;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID Id;
    private String Name;
}

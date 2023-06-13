package com.example.pzarticlenotificator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    private UUID id;
    private UUID userId;
    private UUID topicId;
}

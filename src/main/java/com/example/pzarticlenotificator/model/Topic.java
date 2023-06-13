package com.example.pzarticlenotificator.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
public class Topic {
    private UUID id;
    private UUID author;
    private String title;
    private String description;
}

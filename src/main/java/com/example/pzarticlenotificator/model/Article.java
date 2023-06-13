package com.example.pzarticlenotificator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {

    private UUID id;
    private UUID author;

    private Topic topic;
    private String title;
    private List<String> tags;
    private LocalDateTime createdAt;
    private String content;
    private List<URL> images;
}

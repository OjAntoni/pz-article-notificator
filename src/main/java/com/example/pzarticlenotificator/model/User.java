package com.example.pzarticlenotificator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private UUID id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private WorkPlace workPlace;
    private URL urlToImage;

}

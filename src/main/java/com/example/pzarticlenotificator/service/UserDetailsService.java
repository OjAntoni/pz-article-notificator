package com.example.pzarticlenotificator.service;

import com.example.pzarticlenotificator.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "user-details-service", url = "${user-details-service.url}")
public interface UserDetailsService {

    @GetMapping("/api/v1/user/{id}")
    User getById(@PathVariable UUID id);
}

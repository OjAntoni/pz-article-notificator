package com.example.pzarticlenotificator.service;

import com.example.pzarticlenotificator.model.Subscription;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "user-client", url = "${user-client.url}")
public interface UserActivityService {

    @GetMapping("/api/v1/subscription/all")
    List<Subscription> getAllByTopic(@RequestParam UUID topicId);
}

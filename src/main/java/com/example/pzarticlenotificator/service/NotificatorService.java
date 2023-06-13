package com.example.pzarticlenotificator.service;

import com.example.pzarticlenotificator.model.Article;
import com.example.pzarticlenotificator.model.Subscription;
import com.example.pzarticlenotificator.model.User;
import com.example.pzarticlenotificator.model.UserMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotificatorService {

    @Autowired
    @Qualifier("messagesMB")
    private JmsTemplate jmsMessages;

    @Autowired
    private UserActivityService activityService;

    @Autowired
    private UserDetailsService detailsService;
    @Autowired
    private ObjectMapper objectMapper;



    @JmsListener(destination = "ArticleMB")
    @SneakyThrows
    public void formMessage(String json) {
        Article article = objectMapper.readValue(json, Article.class);
        System.out.println(article);
        if(article.getTopic()==null) return;
        UUID topicId = article.getTopic().getId();
        User author = detailsService.getById(article.getAuthor());
        List<Subscription> subs = activityService.getAllByTopic(topicId);
        List<UUID> userIds = subs.stream().map(Subscription::getUserId).toList();
        List<String> emails = new ArrayList<>();
        userIds.forEach(id -> {
            User byId = detailsService.getById(id);
            if(byId!=null) emails.add(byId.getEmail());
        });
        List<UserMessage> messages = emails.stream().map(e ->
                UserMessage.builder().author(author.getUsername())
                        .articleTitle(article.getTitle())
                        .email(e)
                        .topicTitle(article.getTopic().getTitle())
                        .build()).toList();
        messages.forEach(m -> jmsMessages.convertAndSend("MessagesMB",m));
    }
}

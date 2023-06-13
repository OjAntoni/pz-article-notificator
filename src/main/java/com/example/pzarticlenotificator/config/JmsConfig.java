package com.example.pzarticlenotificator.config;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {

    @Value("${spring.activemq.broker-url1}")
    private String brokerUrl1;

    @Value("${spring.activemq.broker-url2}")
    private String brokerUrl2;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "articleMB")
    public JmsTemplate jmsTemplate1() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory1());
        // Additional configuration for JmsTemplate if needed
        return jmsTemplate;
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory1() {
        return new ActiveMQConnectionFactory(brokerUrl1);
    }

    @Bean(name = "messagesMB")
    public JmsTemplate jmsTemplate2() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory2());
        // Additional configuration for JmsTemplate if needed
        return jmsTemplate;
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory2() {
        return new ActiveMQConnectionFactory(brokerUrl2);
    }

    @Bean(name = "jmsListenerContainerFactory")
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory1(ConnectionFactory activeMQConnectionFactory1) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory1);
        // Customize other properties as per your requirements
        return factory;
    }
//
//    @Bean(name = "jmsListenerContainerFactory2")
//    public JmsListenerContainerFactory<?> jmsListenerContainerFactory2(ConnectionFactory activeMQConnectionFactory2) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setConnectionFactory(activeMQConnectionFactory2);
//        // Customize other properties as per your requirements
//        return factory;
//    }
}

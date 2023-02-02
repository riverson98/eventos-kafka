package com.rcosta.eventos.configuracao;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class ConfigTopico {

    @Value("${kafka.rcosta.topico.nome}")
    private String nomeTopico;

    @Bean
    public NewTopic topicRcosta(){
        return  TopicBuilder.name(nomeTopico).partitions(2)
                .replicas(1).build();
    }
}

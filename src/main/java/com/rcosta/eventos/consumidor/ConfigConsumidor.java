package com.rcosta.eventos.consumidor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConfigConsumidor {
    @RetryableTopic(attempts = "2")
    @KafkaListener(topics = "${kafka.rcosta.topico.nome}", groupId = "rcostaGroup")
    public void consumirMensagem(String mensagem){
        if (mensagem.contains("DLT")){
            throw new IllegalArgumentException("Teste de DLT");
        }

        log.info("============================ RECEBENDO MENSAGEM ============================");
        log.info("============================ " + mensagem  + " ============================");
        log.info("============================ FIM RECEBENDO MENSAGEM ============================");
    }

    @DltHandler
    public void consumirMensagemDLT(String mensagem){
        log.info("============================ RECEBENDO MENSAGEM DA DLT ============================");
        log.info("============================ " + mensagem  + " ============================");
        log.info("============================ FIM RECEBENDO MENSAGEM DA DLT ============================");
    }
}

package com.rcosta.eventos.produtor;

import com.rcosta.eventos.servico.ServicoEnvioDeMensagemKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos")
public class ProdutorController {

    @Autowired
    private ServicoEnvioDeMensagemKafka envioDeMensagemKafka;

    @PostMapping
    public void enviaMensagem(@RequestBody String mensagem) {
        envioDeMensagemKafka.enviarMensagem(mensagem);

    }
}

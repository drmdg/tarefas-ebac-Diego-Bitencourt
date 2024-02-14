package br.com.ebac.eventosdemo.configuracao;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConfigConsumidor {
    @KafkaListener(topics = "${kafka.ebac.nome.topico}",groupId = "ebacGroup")
    public void consumirMensagem(String message){
        System.out.println("======== Recebendo mensagem ========");
        System.out.println("======== "+message+" ========");
        System.out.println("======== FIM Recebendo mensagem ========");

    }
}

package br.com.ebac.eventosdemo.produtor;

import br.com.ebac.eventosdemo.servico.ServicoEnvioMensagemKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos")
public class produtorController {

    @Autowired
    private ServicoEnvioMensagemKafka servicoEnvioMensagemKafka;

    @PostMapping
    public void enviaMensagem(@RequestBody String mensagem){
        servicoEnvioMensagemKafka.enviarMensagem(mensagem);
    }
}

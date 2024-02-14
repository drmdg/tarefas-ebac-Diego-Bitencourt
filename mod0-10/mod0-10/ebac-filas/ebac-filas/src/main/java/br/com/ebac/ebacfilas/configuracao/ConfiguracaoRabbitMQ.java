package br.com.ebac.ebacfilas.configuracao;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoRabbitMQ {

    public static final String NOME_FILA = "fila-ebac";

    public static final String NOME_EXCHANGE = "exchange-ebac";

    public static final String NOME_ROTA = "ebac.rota.#";


    @Bean
    public Queue queue (){
        return new Queue(NOME_FILA,false);
    }

    public TopicExchange exchange(){
        return new TopicExchange(NOME_EXCHANGE);
    }

    public Binding binding(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(NOME_ROTA);
    }
}

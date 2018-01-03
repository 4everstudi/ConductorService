package de.thkoeln.f10.msc.sin.conductor;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

import static de.thkoeln.f10.msc.sin.conductor.SpringAmqpConfig.topicExchangeName;
import static de.thkoeln.f10.msc.sin.conductor.SpringAmqpConfig.topicQueue2Name;

@Profile({"queuea","hello-world"})
@Configuration
public class QueueAConfig {

    @Bean
    public List<Declarable> fanoutBindings() {
        Queue fanoutQueue1 = new Queue("fanout.queue1", false);
        Queue fanoutQueue2 = new Queue("fanout.queue2", false);
        FanoutExchange fanoutExchange = new FanoutExchange("fanout.exchange");

        return Arrays.asList(
                fanoutQueue1,
                fanoutQueue2,
                fanoutExchange,
                BindingBuilder.bind(fanoutQueue2).to(fanoutExchange));
    }

    @Bean
    public List<Declarable> topicBindings() {
        Queue topicQueue1 = new Queue("", false);
        Queue topicQueue2 = new Queue(topicQueue2Name, false);

        TopicExchange topicExchange = new TopicExchange(topicExchangeName);

        return Arrays.asList(
                topicQueue1,
                topicQueue2,
                topicExchange,
                BindingBuilder
                        .bind(topicQueue1)
                        .to(topicExchange).with("*.important.*"),
                BindingBuilder
                        .bind(topicQueue2)
                        .to(topicExchange).with("#.error"));
    }
}

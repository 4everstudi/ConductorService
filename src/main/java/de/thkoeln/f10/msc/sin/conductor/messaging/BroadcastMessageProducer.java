package de.thkoeln.f10.msc.sin.conductor.messaging;

import de.thkoeln.f10.msc.sin.conductor.QueueAConfig;
import de.thkoeln.f10.msc.sin.conductor.SpringAmqpConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BroadcastMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessages(String message) {
        rabbitTemplate.convertAndSend(
                SpringAmqpConfig.fanoutExchangeName, "", message);
        rabbitTemplate.convertAndSend(
                SpringAmqpConfig.topicExchangeName, "user.not-important.info", message);
        rabbitTemplate.convertAndSend(
                SpringAmqpConfig.topicExchangeName, "user.important.error", message);
    }
}

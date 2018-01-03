package de.thkoeln.f10.msc.sin.conductor.messaging;

import de.thkoeln.f10.msc.sin.conductor.SpringAmqpConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class BroadcastMessageConsumers {

    @RabbitListener(queues = {SpringAmqpConfig.fanoutQueue1Name})
    public void receiveMessageFromFanout1(String message) {
    }

    @RabbitListener(queues = {SpringAmqpConfig.fanoutQueue2Name})
    public void receiveMessageFromFanout2(String message) {
    }

    @RabbitListener(queues = {SpringAmqpConfig.topicQueue1Name})
    public void receiveMessageFromTopic1(String message) {
    }

    @RabbitListener(queues = {SpringAmqpConfig.topicQueue2Name})
    public void receiveMessageFromTopic2(String message) {
    }
}

package com.roncoo.eshop.product.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 陈思男
 * @date 2020年04月16日 11:21
 */

@Component
@Configuration
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String queue, String message) {
        this.rabbitTemplate.convertAndSend(queue, message);
    }

}

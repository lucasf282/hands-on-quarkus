package br.com.lucasf282.todoList.service;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@ApplicationScoped
public class NotificacaoService {

    private static final String QUEUE_NAME = "tarefas";

    public void notificar(String nomeFila, String message) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(nomeFila, false, false, false, null);
            channel.basicPublish("", nomeFila, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

    public void messageReceiver () {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }

    }

}

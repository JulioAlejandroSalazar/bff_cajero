package com.duoc.bff_cajero.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransaccionProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public TransaccionProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarEvento(String mensaje) {
        kafkaTemplate.send("transacciones-eventos", mensaje);
    }
}

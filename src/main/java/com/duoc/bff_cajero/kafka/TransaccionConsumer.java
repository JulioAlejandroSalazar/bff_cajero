package com.duoc.bff_cajero.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransaccionConsumer {

    @KafkaListener(topics = "transacciones-eventos", groupId = "grupo-bff")
    public void consumirEvento(String mensaje) {
        System.out.println("Evento recibido: " + mensaje);
    }
}

package com.duoc.bff_cajero.controller;

import com.duoc.bff_cajero.dto.CuentaAnualDto;
import com.duoc.bff_cajero.dto.InteresDto;
import com.duoc.bff_cajero.dto.TransaccionDto;
import com.duoc.bff_cajero.service.TransaccionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bff/cajero")
public class CajeroController {

    private final RestTemplate restTemplate;
    private final TransaccionService transaccionService;

    public CajeroController(RestTemplate restTemplate, TransaccionService transaccionService) {
        this.restTemplate = restTemplate;
        this.transaccionService = transaccionService;
    }

    @GetMapping("/transacciones")
    public List<TransaccionDto> getTransaccionesCajero() {
        return transaccionService.obtenerTransacciones();
    }

    @GetMapping("/intereses")
    public List<InteresDto> getInteresesCajero() {
        InteresDto[] intereses = restTemplate.getForObject(
                "http://ms-intereses/api/intereses", InteresDto[].class);
        if (intereses == null) return List.of();
        return Arrays.stream(intereses)
                .map(i -> {
                    InteresDto dto = new InteresDto();
                    dto.setCuentaId(i.getCuentaId());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/cuentas_anuales")
    public List<CuentaAnualDto> getCuentasAnualesCajero() {
        CuentaAnualDto[] cuentas = restTemplate.getForObject(
                "http://ms-cuentas-anuales/api/cuentas_anuales", CuentaAnualDto[].class);
        if (cuentas == null) return List.of();
        return Arrays.stream(cuentas)
                .map(c -> {
                    CuentaAnualDto dto = new CuentaAnualDto();
                    dto.setCuentaId(c.getCuentaId());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}

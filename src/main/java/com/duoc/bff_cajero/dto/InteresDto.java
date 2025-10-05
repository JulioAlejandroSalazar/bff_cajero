package com.duoc.bff_cajero.dto;

import java.math.BigDecimal;

public class InteresDto {

    private Long cuentaId;
    private String nombre;
    private BigDecimal saldo;
    private Integer edad;
    private BigDecimal interesAplicado;
    private BigDecimal saldoFinal;

    // getters y setters
    public Long getCuentaId() { return cuentaId; }
    public void setCuentaId(Long cuentaId) { this.cuentaId = cuentaId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public BigDecimal getSaldo() { return saldo; }
    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }

    public BigDecimal getInteresAplicado() { return interesAplicado; }
    public void setInteresAplicado(BigDecimal interesAplicado) { this.interesAplicado = interesAplicado; }

    public BigDecimal getSaldoFinal() { return saldoFinal; }
    public void setSaldoFinal(BigDecimal saldoFinal) { this.saldoFinal = saldoFinal; }
}

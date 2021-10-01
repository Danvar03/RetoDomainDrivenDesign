package com.sofka.retovuelo.domain.vuelo.command;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.vuelo.values.Estado;


public class EstadoCambiadoDelAeropuerto extends DomainEvent {

    private final Estado estado;

    public EstadoCambiadoDelAeropuerto(Estado estado) {
        super("ventatiquetes.vuelo.estadocambiado");
        this.estado=estado;
    }


    public Estado getEstado() {
        return estado;
    }
}

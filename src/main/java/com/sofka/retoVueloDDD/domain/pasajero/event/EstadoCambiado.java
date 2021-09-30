package com.sofka.retoVueloDDD.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retoVueloDDD.domain.pasajero.values.Estado;

public class EstadoCambiado extends DomainEvent {

    private final Estado estado;

    public EstadoCambiado(Estado estado) {
        super("aerolinea.ventatiquetes.domain.pasajero.estadocambiado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}

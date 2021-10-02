package com.sofka.retovuelo.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.pasajero.values.Estado;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;

public class EstadoCambiado extends DomainEvent {
    private final PasajeroId pasajeroId;
    private final Estado estado;

    public EstadoCambiado(PasajeroId pasajeroId, Estado estado) {
        super("aerolinea.ventatiquetes.domain.pasajero.estadocambiado");
        this.pasajeroId = pasajeroId;
        this.estado = estado;
    }

    public PasajeroId getPasajeroId() {
        return pasajeroId;
    }

    public Estado getEstado() {
        return estado;
    }
}

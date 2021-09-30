package com.sofka.retoVueloDDD.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retoVueloDDD.domain.genericvalues.Origen;

public class OrigenMoficado  extends DomainEvent {
    private final Origen origen;

    public OrigenMoficado(String type, Origen origen) {
        super("aerolinea.ventatiquetes.domain.pasajero.OrigenModificado");
        this.origen = origen;
    }
}

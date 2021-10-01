package com.sofka.retovuelo.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Origen;

public class OrigenModificado extends DomainEvent {
    private final Origen origen;

    public OrigenModificado(Origen origen) {
        super("aerolinea.ventatiquetes.domain.pasajero.OrigenModificado");
        this.origen = origen;
    }
}

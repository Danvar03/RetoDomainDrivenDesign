package com.sofka.retovuelo.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Destino;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;

public class DestinoModificado extends DomainEvent {
    private final PasajeroId pasajeroId;
    private final Destino destino;

    public DestinoModificado(PasajeroId pasajeroId, Destino destino) {
        super("aerolinea.ventatiquetes.domain.pasajero.destinocambiado");
        this.pasajeroId = pasajeroId;
        this.destino = destino;
    }

    public PasajeroId getPasajeroId() {
        return pasajeroId;
    }

    public Destino getDestino() {
        return destino;
    }
}

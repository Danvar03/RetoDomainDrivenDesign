package com.sofka.retovuelo.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;

public class PasajeroAgregado extends DomainEvent {

    private final PasajeroId pasajeroId;
    private final Nombre nombre;


    public PasajeroAgregado(PasajeroId pasajeroId, Nombre nombre) {
        super("ventatiquetes.pasajero.pasajeroregistrado");
        this.pasajeroId = pasajeroId;
        this.nombre = nombre;
    }

    public PasajeroId getPasajeroId() {
        return pasajeroId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

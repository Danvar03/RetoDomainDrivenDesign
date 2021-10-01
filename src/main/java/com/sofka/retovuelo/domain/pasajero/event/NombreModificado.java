package com.sofka.retovuelo.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;

public class NombreModificado extends DomainEvent {
    private final PasajeroId pasajeroId;
    private final Nombre nombre;



    public NombreModificado(PasajeroId pasajeroId, Nombre nombre) {
        super("aerolinea.ventatiquetes.domain.pasajero.nombrecambiado");
        this.pasajeroId = pasajeroId;
        this.nombre=nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

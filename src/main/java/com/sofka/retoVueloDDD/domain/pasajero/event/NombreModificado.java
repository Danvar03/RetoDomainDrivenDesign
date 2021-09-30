package com.sofka.retoVueloDDD.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retoVueloDDD.domain.genericvalues.Nombre;

public class NombreModificado extends DomainEvent {

    private final Nombre nombre;
    public NombreModificado(Nombre nombre) {
        super("aerolinea.ventatiquetes.domain.pasajero.nombrecambiado");
        this.nombre=nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

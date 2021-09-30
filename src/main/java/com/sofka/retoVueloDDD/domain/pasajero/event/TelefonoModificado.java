package com.sofka.retoVueloDDD.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retoVueloDDD.domain.pasajero.values.Telefono;

public class TelefonoModificado extends DomainEvent {

    private final Telefono telefono;

    public TelefonoModificado(String type, Telefono telefono) {
        super("aerolinea.ventatiquetes.domain.pasajero.tipodepagomodificado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}

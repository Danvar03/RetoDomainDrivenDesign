package com.sofka.retovuelo.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.pasajero.values.Telefono;

public class TelefonoModificado extends DomainEvent {

    private final Telefono telefono;

    public TelefonoModificado(Telefono telefono) {
        super("aerolinea.ventatiquetes.domain.pasajero.tipodepagomodificado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}

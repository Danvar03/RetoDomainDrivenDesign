package com.sofka.retoVueloDDD.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retoVueloDDD.domain.genericvalues.Destino;

public class DestinoModificado extends DomainEvent {

    private final Destino destino;

    public DestinoModificado(String type, Destino destino) {
        super("aerolinea.ventatiquetes.domain.pasajero.destinocambiado");
        this.destino = destino;
    }

    public Destino getDestino() {
        return destino;
    }
}
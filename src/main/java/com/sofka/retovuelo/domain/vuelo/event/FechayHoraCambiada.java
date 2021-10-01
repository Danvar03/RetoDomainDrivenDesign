package com.sofka.retovuelo.domain.vuelo.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Fecha;


public class FechayHoraCambiada extends DomainEvent {

    private final Fecha fecha;

    public FechayHoraCambiada(Fecha fecha) {
        super("ventatiquetes.vuelo.fechayHoraCambiada");
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }
}

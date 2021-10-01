package com.sofka.retovuelo.domain.vuelo.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.vuelo.values.Duracion;


public class DuracionCambiada extends DomainEvent {

    private final Duracion duracion;

    public DuracionCambiada(Duracion duracion) {
        super("ventatiquetes.vuelo.duracioncambiada");
        this.duracion=duracion;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}

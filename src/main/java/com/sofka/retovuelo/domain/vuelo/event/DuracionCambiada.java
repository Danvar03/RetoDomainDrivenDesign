package com.sofka.retovuelo.domain.vuelo.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.vuelo.values.Duracion;
import com.sofka.retovuelo.domain.vuelo.values.VueloId;


public class DuracionCambiada extends DomainEvent {

    private final Duracion duracion;

    public DuracionCambiada(VueloId vueloId, Duracion duracion) {
        super("ventatiquetes.vuelo.duracioncambiada");

        this.duracion = duracion;
    }


    public Duracion getDuracion() {
        return duracion;
    }
}

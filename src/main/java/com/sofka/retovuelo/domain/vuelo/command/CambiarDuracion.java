package com.sofka.retovuelo.domain.vuelo.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.vuelo.values.Duracion;
import com.sofka.retovuelo.domain.vuelo.values.VueloId;


public class CambiarDuracion extends Command {
    private final VueloId vueloId;
    private final Duracion duracion;


    public CambiarDuracion(VueloId vueloId, Duracion duracion) {
        this.vueloId = vueloId;
        this.duracion = duracion;
    }

    public VueloId getVueloId() {
        return vueloId;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}

package com.sofka.retovuelo.domain.vuelo.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.vuelo.values.Duracion;


public class CambiarDuracion extends Command {

    private final Duracion duracion;

    public CambiarDuracion(Duracion duracion) {
        this.duracion = duracion;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}

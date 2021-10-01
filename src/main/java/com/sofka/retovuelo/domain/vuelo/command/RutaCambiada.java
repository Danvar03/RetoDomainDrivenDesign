package com.sofka.retovuelo.domain.vuelo.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.vuelo.values.Ruta;


public class RutaCambiada extends Command {

    private final Ruta ruta;

    public RutaCambiada(Ruta ruta) {
        this.ruta=ruta;
    }

    public Ruta getRuta() {
        return ruta;
    }
}

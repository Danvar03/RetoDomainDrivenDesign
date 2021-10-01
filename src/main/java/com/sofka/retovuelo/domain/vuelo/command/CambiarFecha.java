package com.sofka.retovuelo.domain.vuelo.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Fecha;


public class CambiarFecha extends Command {

    private final Fecha fecha;

    public CambiarFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }
}

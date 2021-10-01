package com.sofka.retovuelo.domain.vuelo.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.vuelo.values.Turno;


public class TurnoCambiar extends Command {

    private final Turno turno;

    public TurnoCambiar(Turno turno) {

        this.turno = turno;
    }

    public Turno getTurno() {
        return turno;
    }
}

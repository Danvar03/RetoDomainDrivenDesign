package com.sofka.retovuelo.domain.vuelo.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.vuelo.values.Turno;
import com.sofka.retovuelo.domain.vuelo.values.VueloId;


public class TurnoCambiar extends Command {
 private final VueloId vueloId;
    private final Turno turno;

    public TurnoCambiar(VueloId vueloId, Turno turno) {
        this.vueloId = vueloId;

        this.turno = turno;
    }

    public VueloId getVueloId() {
        return vueloId;
    }

    public Turno getTurno() {
        return turno;
    }
}

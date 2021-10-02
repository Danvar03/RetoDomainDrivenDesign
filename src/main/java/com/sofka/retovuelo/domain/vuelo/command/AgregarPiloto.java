package com.sofka.retovuelo.domain.vuelo.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.vuelo.values.PilotoId;
import com.sofka.retovuelo.domain.vuelo.values.Turno;
import com.sofka.retovuelo.domain.vuelo.values.VueloId;

public class AgregarPiloto extends Command {
    private final VueloId vueloId;
    private  final PilotoId pilotoId;
    private final Nombre nombre;
    private final Turno turno;

    public AgregarPiloto(VueloId vueloId, PilotoId pilotoId, Nombre nombre, Turno turno) {
        this.vueloId = vueloId;
        this.pilotoId = pilotoId;
        this.nombre = nombre;
        this.turno = turno;
    }

    public VueloId getVueloId() {
        return vueloId;
    }

    public PilotoId getPilotoId() {
        return pilotoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Turno getTurno() {
        return turno;
    }
}

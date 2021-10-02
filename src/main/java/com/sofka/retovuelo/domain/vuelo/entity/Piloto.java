package com.sofka.retovuelo.domain.vuelo.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.vuelo.values.PilotoId;
import com.sofka.retovuelo.domain.vuelo.values.Turno;

import java.util.Objects;

public class Piloto extends Entity<PilotoId> {
    private Nombre nombre;
    private Turno turno;


    public Piloto(PilotoId pilotoId, Nombre nombrepiloto, Turno turno) {
        super(pilotoId);
        this.nombre = nombrepiloto;
        this.turno = turno;
    }

    public void cambiarnormbrepiloto(Nombre nombrepiloto) {
        this.nombre = Objects.requireNonNull(nombrepiloto);
    }

    public void cambiarturno(Turno turno) {
        this.turno = Objects.requireNonNull(turno);
    }
    //propiedades

    public Nombre getNombre() {
        return nombre;
    }

    public Turno getTurno() {
        return turno;
    }
}
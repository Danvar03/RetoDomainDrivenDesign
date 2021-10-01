package com.sofka.retovuelo.domain.vuelo.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.vuelo.values.PilotoId;
import com.sofka.retovuelo.domain.vuelo.values.Turno;

import java.util.Objects;

public class  Piloto extends Entity<PilotoId> {

    private Nombre nombrepiloto;
    private Turno turno;

    public Piloto(PilotoId entityId, Nombre nombrepiloto, Turno turno) {
        super(entityId);
        this.nombrepiloto = nombrepiloto;
        this.turno = turno;
    }

    //comportamientos

    //comportamientos
    public void cambiarnormbrepiloto(Nombre nombrepiloto){
        this.nombrepiloto= Objects.requireNonNull(nombrepiloto);
    }

    public void cambiarturno(Turno turno){
        this.turno= Objects.requireNonNull(turno);
    }
    //propiedades

    public Nombre getNombrepiloto() {
        return nombrepiloto;
    }

    public Turno getTurno() {
        return turno;
    }
}
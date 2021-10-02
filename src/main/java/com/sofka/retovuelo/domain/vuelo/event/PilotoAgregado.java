package com.sofka.retovuelo.domain.vuelo.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.vuelo.values.PilotoId;
import com.sofka.retovuelo.domain.vuelo.values.Turno;

public class PilotoAgregado extends DomainEvent {
    private  final PilotoId pilotoId;
    private final Nombre nombre;
    private final Turno turno;

    public PilotoAgregado(PilotoId pilotoId, Nombre nombre, Turno turno) {
        super("aerolinea.ventatiquetes.domain.vuelo.pilotoAgregado");
        this.pilotoId = pilotoId;
        this.nombre = nombre;
        this.turno = turno;
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

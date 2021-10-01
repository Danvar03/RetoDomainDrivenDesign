package com.sofka.retovuelo.domain.vuelo.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.retovuelo.domain.genericvalues.Destino;
import com.sofka.retovuelo.domain.genericvalues.Origen;
import com.sofka.retovuelo.domain.vuelo.values.Escala;
import com.sofka.retovuelo.domain.vuelo.values.TrayectoId;

public class Trayecto extends Entity<TrayectoId> {
    private final Destino destino;
    private final Escala escala;
    private final Origen origen;

    public Trayecto(TrayectoId entityId, Destino destino, Escala escala, Origen origen) {
        super(entityId);
        this.destino = destino;
        this.escala = escala;
        this.origen = origen;
    }

    public Destino getDestino() {
        return destino;
    }

    public Escala getEscala() {
        return escala;
    }

    public Origen getOrigen() {
        return origen;
    }
}

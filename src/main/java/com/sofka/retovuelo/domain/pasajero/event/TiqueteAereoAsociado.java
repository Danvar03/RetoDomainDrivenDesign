package com.sofka.retovuelo.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Destino;
import com.sofka.retovuelo.domain.genericvalues.Origen;
import com.sofka.retovuelo.domain.pasajero.values.Asiento;
import com.sofka.retovuelo.domain.pasajero.values.Estado;
import com.sofka.retovuelo.domain.pasajero.values.TiqueteId;


public class TiqueteAereoAsociado extends DomainEvent {
    private final TiqueteId tiqueteId;
    private final Origen origen;
    private final Asiento asiento;
    private final Destino destino;
    private final Estado estado;

    public TiqueteAereoAsociado(TiqueteId tiqueteId ,Origen origen, Asiento asiento, Destino destino, Estado estado) {
        super("aerolinea.ventatiquetes.domain.pasajero.datosPasajeroActualiza");
        this.tiqueteId = tiqueteId;
        this.origen = origen;
        this.asiento = asiento;
        this.destino = destino;
        this.estado = estado;
    }



    public TiqueteId getTiqueteId() {
        return tiqueteId;
    }

    public Origen getOrigen() {
        return origen;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public Destino getDestino() {
        return destino;
    }

    public Estado getEstado() {
        return estado;
    }
}

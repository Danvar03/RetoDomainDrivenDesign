package com.sofka.retovuelo.domain.pasajero.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.retovuelo.domain.genericvalues.Destino;
import com.sofka.retovuelo.domain.genericvalues.Origen;
import com.sofka.retovuelo.domain.pasajero.values.Asiento;
import com.sofka.retovuelo.domain.pasajero.values.Estado;
import com.sofka.retovuelo.domain.pasajero.values.TiqueteId;

import java.util.Objects;

public class TiqueteArereo extends Entity<TiqueteId> {

    private  Origen origen;
    private  Asiento asiento;
    private  Destino destino;
    private  Estado estado;

    public TiqueteArereo(TiqueteId tiqueteId, Origen origen, Asiento asiento, Destino destino, Estado estado) {
        super(tiqueteId);
        this.origen=origen;
        this.asiento=asiento;
        this.destino=destino;
        this.estado=estado;
    }

    //comportamientos
    public void modificarorigen(Origen origen){
        this.origen= Objects.requireNonNull(origen);
    }

    public void modificardestino(Destino destino){
        this.destino= Objects.requireNonNull(destino);
    }
    public void cambiarestado( Estado estado){
        this.estado= Objects.requireNonNull(estado);
    }

    //Propiedades

    public Estado Estado() {
        return estado;
    }

    public Origen Origen() {
        return origen;
    }

    public Destino Destino() {
        return destino;
    }

    public Asiento Asiento() {
        return asiento;
    }
}

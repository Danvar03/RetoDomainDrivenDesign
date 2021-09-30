package com.sofka.retoVueloDDD.domain.pasajero.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.retoVueloDDD.domain.genericvalues.Destino;
import com.sofka.retoVueloDDD.domain.genericvalues.Origen;
import com.sofka.retoVueloDDD.domain.pasajero.values.Asiento;
import com.sofka.retoVueloDDD.domain.pasajero.values.Estado;
import com.sofka.retoVueloDDD.domain.pasajero.values.TiqueteId;

import java.util.Objects;

public class Tiquete extends Entity<TiqueteId> {

    private Origen origen;
    private Asiento asiento;
    private Destino destino;
    private Estado estado;

    public Tiquete(TiqueteId entityId, Origen origen, Asiento asiento, Destino destino, Estado estado) {
        super(entityId);
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

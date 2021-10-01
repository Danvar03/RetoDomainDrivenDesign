package com.sofka.retovuelo.domain.vuelo.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.retovuelo.domain.vuelo.values.*;

import java.util.Objects;

public class Avion extends Entity<AvionId> {

    private final ModeloAvion modeloAvion;
    private final Capacidad capacidad;
    private Ruta ruta;
    private final Aerolinea aerolinea;

    public Avion(AvionId entityId, ModeloAvion tipo, Capacidad capacidad, Ruta ruta, Aerolinea aerolinea) {
        super(entityId);
        this.modeloAvion =tipo;
        this.capacidad=capacidad;
        this.ruta=ruta;
        this.aerolinea=aerolinea;
    }

    //comportamientos
    public void cambiarruta(Ruta ruta){
        this.ruta= Objects.requireNonNull(ruta);
    }


    //propiedades
    public ModeloAvion Tipo() {
        return modeloAvion;
    }

    public Capacidad Capacidad() {
        return capacidad;
    }

    public Ruta Ruta() {
        return ruta;
    }

    public Aerolinea Aerolinea() {
        return aerolinea;
    }
}

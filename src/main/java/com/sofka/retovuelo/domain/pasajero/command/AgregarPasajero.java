package com.sofka.retovuelo.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;


public class AgregarPasajero implements Command {
    private final PasajeroId pasajeroId;
    private final Nombre nombre;


    public AgregarPasajero(PasajeroId pasajeroId, Nombre nombre) {
        this.pasajeroId = pasajeroId;
        this.nombre = nombre;
    }

    public PasajeroId getPasajeroId() {
        return pasajeroId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
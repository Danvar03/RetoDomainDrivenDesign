package com.sofka.retoVueloDDD.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retoVueloDDD.domain.genericvalues.Nombre;
import com.sofka.retoVueloDDD.domain.pasajero.values.PasajeroId;

public class ModificarNombre implements Command {

    private final PasajeroId pasajeroId;
    private final Nombre nombre;

    public ModificarNombre(PasajeroId pasajeroId, Nombre nombre) {
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

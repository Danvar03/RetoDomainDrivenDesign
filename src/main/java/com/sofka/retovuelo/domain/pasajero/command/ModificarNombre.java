package com.sofka.retovuelo.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;

public class ModificarNombre extends Command {

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

package com.sofka.retovuelo.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.genericvalues.Origen;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;

public class ModificarOrigenDeTiquete implements Command {

    private final PasajeroId pasajeroId;
    private final Origen origen;

    public ModificarOrigenDeTiquete(PasajeroId pasajeroId, Origen origen) {
        this.pasajeroId = pasajeroId;
        this.origen = origen;
    }

    public PasajeroId getpasajeroId() {
        return pasajeroId;
    }

    public Origen getOrigen() {
        return origen;
    }
}

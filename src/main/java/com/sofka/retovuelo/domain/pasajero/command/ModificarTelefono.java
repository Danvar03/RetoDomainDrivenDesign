package com.sofka.retovuelo.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;
import com.sofka.retovuelo.domain.pasajero.values.Telefono;

public class ModificarTelefono extends Command {
    private final PasajeroId pasajeroId;
    private final Telefono telefono;

    public ModificarTelefono(PasajeroId pasajeroId, Telefono telefono) {
        this.pasajeroId = pasajeroId;
        this.telefono = telefono;
    }

    public PasajeroId getPasajeroId() {
        return pasajeroId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}

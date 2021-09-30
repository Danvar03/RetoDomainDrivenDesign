package com.sofka.retoVueloDDD.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retoVueloDDD.domain.pasajero.values.MetodoPago;
import com.sofka.retoVueloDDD.domain.pasajero.values.PasajeroId;

public class ModificarMetodoDePago implements Command {

    private final PasajeroId pasajeroId;
    private final MetodoPago metododepago;

    public ModificarMetodoDePago(PasajeroId pasajeroId, MetodoPago metododepago) {
        this.pasajeroId = pasajeroId;
        this.metododepago = metododepago;
    }

    public PasajeroId getPasajeroId() {
        return pasajeroId;
    }

    public MetodoPago getMetododepago() {
        return metododepago;
    }
}

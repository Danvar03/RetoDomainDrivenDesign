package com.sofka.retoVueloDDD.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retoVueloDDD.domain.pasajero.values.Estado;
import com.sofka.retoVueloDDD.domain.pasajero.values.PasajeroId;

public class CambiarEstadoDeTiquete implements Command {

    private final PasajeroId pasajeroId;
    private final Estado estado;

    public CambiarEstadoDeTiquete(PasajeroId pasajeroId, Estado estado) {
        this.pasajeroId = pasajeroId;
        this.estado = estado;
    }

    public PasajeroId getPasajeroId() {
        return pasajeroId;
    }

    public Estado getEstado() {
        return estado;
    }
}

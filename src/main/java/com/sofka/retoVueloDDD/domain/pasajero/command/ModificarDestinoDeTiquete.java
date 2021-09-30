package com.sofka.retoVueloDDD.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retoVueloDDD.domain.genericvalues.Destino;
import com.sofka.retoVueloDDD.domain.pasajero.values.PasajeroId;

public class ModificarDestinoDeTiquete implements Command {

    private final PasajeroId pasajeroId;
    private final Destino destino;


    public ModificarDestinoDeTiquete(PasajeroId pasajeroId, Destino destino) {
        this.pasajeroId = pasajeroId;
        this.destino = destino;
    }

    public PasajeroId getPasajeroId() {
        return pasajeroId;
    }

    public Destino getDestino() {
        return destino;
    }
}

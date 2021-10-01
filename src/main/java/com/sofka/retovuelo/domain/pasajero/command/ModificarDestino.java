package com.sofka.retovuelo.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.genericvalues.Destino;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;

public class ModificarDestino extends Command {

    private final PasajeroId pasajeroId;
    private final Destino destino;


    public ModificarDestino(PasajeroId pasajeroId, Destino destino) {
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

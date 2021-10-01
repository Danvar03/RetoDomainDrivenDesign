package com.sofka.retovuelo.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.genericvalues.Destino;
import com.sofka.retovuelo.domain.genericvalues.Origen;
import com.sofka.retovuelo.domain.pasajero.values.Asiento;
import com.sofka.retovuelo.domain.pasajero.values.Estado;

public class AgregarTiqueteAereo implements Command {
    private final Origen origen;
    private final Asiento asiento;
    private final Destino destino;
    private final Estado estado;

    public AgregarTiqueteAereo(Origen origen, Asiento asiento, Destino destino, Estado estado) {
        this.origen = origen;
        this.asiento = asiento;
        this.destino = destino;
        this.estado = estado;
    }


    public Origen getOrigen() {
        return origen;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public Destino getDestino() {
        return destino;
    }

    public Estado getEstado() {
        return estado;
    }
}

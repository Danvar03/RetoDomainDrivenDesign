package com.sofka.retovuelo.domain.vuelo.command;

import co.com.sofka.domain.generic.Command;

import com.sofka.retovuelo.domain.vuelo.values.Estado;


public class CambiarEstadoDelAeropuerto extends Command {

    private final Estado estado;

    public CambiarEstadoDelAeropuerto(Estado estado) {
        this.estado=estado;
    }


    public Estado getEstado() {
        return estado;
    }
}

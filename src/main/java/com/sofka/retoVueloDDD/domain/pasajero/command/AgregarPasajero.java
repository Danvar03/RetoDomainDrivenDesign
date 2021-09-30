package com.sofka.retoVueloDDD.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retoVueloDDD.domain.genericvalues.Nombre;
import com.sofka.retoVueloDDD.domain.pasajero.entity.Dato;
import com.sofka.retoVueloDDD.domain.pasajero.entity.Pago;

public class AgregarPasajero implements Command {

    private final Nombre nombre;
    private final Pago pago;
    private final Dato datos; // Duda ¿ se puede mandar la entidad datos?


    public AgregarPasajero(Nombre nombre, Pago pago, Dato datos) {
        this.nombre = nombre;
        this.pago = pago;
        this.datos = datos;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Pago getPago() {
        return pago;
    }

    public Dato getDatos() {
        return datos;
    }
}
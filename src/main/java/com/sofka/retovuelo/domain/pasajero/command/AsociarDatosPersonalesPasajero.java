package com.sofka.retovuelo.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.pasajero.values.*;

public class AsociarDatosPersonalesPasajero extends Command {
    private final PasajeroId pasajeroId;
    private final DatoId datoId;
    private final Correo corrreo;
    private final Direccion direccion;
    private final Fecha fechaNacimiento;
    private final Telefono telefono;

    public AsociarDatosPersonalesPasajero(DatoId datoId, PasajeroId pasajeroId, Correo corrreo, Direccion direccion, Fecha fechaNacimiento, Telefono telefono) {
        this.pasajeroId = pasajeroId;
        this.datoId = datoId;
        this.corrreo = corrreo;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public PasajeroId getPasajeroId() {
        return pasajeroId;
    }

    public DatoId getDatoId() {
        return datoId;
    }

    public Correo getCorrreo() {
        return corrreo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}

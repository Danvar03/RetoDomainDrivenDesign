package com.sofka.retovuelo.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.pasajero.values.*;

public class AgregarDatosPersonalesPasajero implements Command {

    private final Correo corrreo;
    private final Direccion direccion;
    private final Fecha fechaNacimiento;
    private final Telefono telefono;

    public AgregarDatosPersonalesPasajero(DatoId datoId, Correo corrreo, Direccion direccion, Fecha fechaNacimiento, Telefono telefono) {

        this.corrreo = corrreo;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
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

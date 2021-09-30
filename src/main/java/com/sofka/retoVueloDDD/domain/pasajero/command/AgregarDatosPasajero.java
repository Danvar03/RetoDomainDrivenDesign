package com.sofka.retoVueloDDD.domain.pasajero.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retoVueloDDD.domain.genericvalues.Fecha;
import com.sofka.retoVueloDDD.domain.pasajero.values.Correo;
import com.sofka.retoVueloDDD.domain.pasajero.values.DatoId;
import com.sofka.retoVueloDDD.domain.pasajero.values.Direccion;
import com.sofka.retoVueloDDD.domain.pasajero.values.Telefono;

public class AgregarDatosPasajero implements Command {
    private final Correo corrreo;
    private final Direccion direccion;
    private final Fecha fechaNacimiento;
    private final Telefono telefono;


    public AgregarDatosPasajero(DatoId datoId,Correo corrreo, Direccion direccion, Fecha fechaNacimiento, Telefono telefono) {
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

package com.sofka.retoVueloDDD.domain.pasajero.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.retoVueloDDD.domain.genericvalues.Fecha;
import com.sofka.retoVueloDDD.domain.pasajero.values.Correo;
import com.sofka.retoVueloDDD.domain.pasajero.values.DatoId;
import com.sofka.retoVueloDDD.domain.pasajero.values.Direccion;
import com.sofka.retoVueloDDD.domain.pasajero.values.Telefono;

import java.util.Objects;

public class Dato  extends Entity<DatoId> {

    private final Correo corrreo;
    private final Direccion direccion;
    private final Fecha fechaNacimiento;
    private  Telefono telefono;


    public Dato(DatoId datoId, Correo corrreo, Direccion direccion, Fecha fechaNacimiento, Telefono telefono) {
        super(datoId);
        this.corrreo = corrreo;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    //comportamiento
    public void cambiartelefono(Telefono telefono){
        this.telefono= Objects.requireNonNull(telefono);
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

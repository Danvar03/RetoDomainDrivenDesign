package com.sofka.retovuelo.domain.pasajero.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.pasajero.values.Correo;
import com.sofka.retovuelo.domain.pasajero.values.DatoId;
import com.sofka.retovuelo.domain.pasajero.values.Direccion;
import com.sofka.retovuelo.domain.pasajero.values.Telefono;

import java.util.Objects;

public class DatosPersonal extends Entity<DatoId> {

    private final Correo corrreo;
    private final Direccion direccion;
    private final Fecha fechaNacimiento;
    private  Telefono telefono;


    public DatosPersonal(DatoId datoId, Correo corrreo, Direccion direccion, Fecha fechaNacimiento, Telefono telefono) {
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

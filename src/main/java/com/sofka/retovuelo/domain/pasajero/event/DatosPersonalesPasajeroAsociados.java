package com.sofka.retovuelo.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.pasajero.values.*;

public class DatosPersonalesPasajeroAsociados extends DomainEvent {
    private  final PasajeroId pasajeroId;
    private final Correo corrreo;
    private final Direccion direccion;
    private final Fecha fechaNacimiento;
    private final Telefono telefono;
    private final DatoId datoId;


    public DatosPersonalesPasajeroAsociados(PasajeroId pasajeroId, DatoId datoId, Correo corrreo, Direccion direccion, Fecha fechaNacimiento, Telefono telefono) {
        super("aerolinea.ventatiquetes.domain.pasajero.destinocambiado");
        this.pasajeroId = pasajeroId;
        this.corrreo = corrreo;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.datoId = datoId;
    }

    public PasajeroId getPasajeroId() {
        return pasajeroId;
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

    public DatoId getDatoId() {
        return datoId;
    }
}



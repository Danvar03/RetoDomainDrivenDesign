package com.sofka.retovuelo.domain.pasajero.command;

import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.pasajero.values.Correo;
import com.sofka.retovuelo.domain.pasajero.values.Direccion;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;
import com.sofka.retovuelo.domain.pasajero.values.Telefono;

public final class ActalizarDatosPasajeroBuilder {
    private PasajeroId pasajeroId;
    private Correo corrreo;
    private Direccion direccion;
    private Fecha fechaNacimiento;
    private Telefono telefono;

    private ActalizarDatosPasajeroBuilder() {
    }

    public static ActalizarDatosPasajeroBuilder anActalizarDatosPasajero() {
        return new ActalizarDatosPasajeroBuilder();
    }

    public ActalizarDatosPasajeroBuilder withPasajeroId(PasajeroId pasajeroId) {
        this.pasajeroId = pasajeroId;
        return this;
    }

    public ActalizarDatosPasajeroBuilder withCorrreo(Correo corrreo) {
        this.corrreo = corrreo;
        return this;
    }

    public ActalizarDatosPasajeroBuilder withDireccion(Direccion direccion) {
        this.direccion = direccion;
        return this;
    }

    public ActalizarDatosPasajeroBuilder withFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public ActalizarDatosPasajeroBuilder withTelefono(Telefono telefono) {
        this.telefono = telefono;
        return this;
    }

    public ActalizarDatosPersonalesPasajero build() {
        return new ActalizarDatosPersonalesPasajero(null, corrreo, direccion, fechaNacimiento, telefono);
    }
}

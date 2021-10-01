package com.sofka.retovuelo.domain.pasajero;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.retovuelo.domain.pasajero.entity.DatosPersonal;
import com.sofka.retovuelo.domain.pasajero.entity.TiqueteArereo;
import com.sofka.retovuelo.domain.pasajero.event.*;

public class PasajeroChange extends EventChange {
    public PasajeroChange(Pasajero pasajero) {
        apply((PasajeroAgregado event) -> {
            pasajero.nombre = event.getNombre();
        });
        apply((DatosPersonalesPasajeroAgregado event) -> {
            pasajero.datosPersonal = new DatosPersonal(
                    event.getDatoId(),
                    event.getCorrreo(),
                    event.getDireccion(),
                    event.getFechaNacimiento(),
                    event.getTelefono());
        });

        apply((TiqueteAereoAgregado event) -> {
            pasajero.tiqueteArereo = new TiqueteArereo(
                    event.getTiqueteId(),
                    event.getOrigen(),
                    event.getAsiento(),
                    event.getDestino(),
                    event.getEstado());
        });


        apply((DatosPasajeroPersonalActualizado event) -> {
            pasajero.datosPersonal = new DatosPersonal(
                    event.getDatoId(),
                    event.getCorrreo(),
                    event.getDireccion(),
                    event.getFechaNacimiento(),
                    event.getTelefono());
        });

        apply((NombreModificado event) -> {
            pasajero.nombre = event.getNombre();
        });

        apply((TelefonoModificado event) -> {
            pasajero.datosPersonal.cambiartelefono(event.getTelefono());
        });

        apply((DestinoModificado event) -> {
            pasajero.tiqueteArereo.modificardestino(event.getDestino());
        });

        apply((EstadoCambiado event) -> {
            pasajero.tiqueteArereo.cambiarestado(event.getEstado());
        });

        apply((TipoDePagoModificado event) -> {
            pasajero.pago.modificartipodepago(event.getMetododepago());
        });

    }

}

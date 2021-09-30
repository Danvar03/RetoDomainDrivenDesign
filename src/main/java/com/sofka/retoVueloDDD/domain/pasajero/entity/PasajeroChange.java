package com.sofka.retoVueloDDD.domain.pasajero.entity;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.retoVueloDDD.domain.pasajero.event.*;

public class PasajeroChange extends EventChange {
    public PasajeroChange(Pasajero pasajero) {
        apply((PasajeroAgregado event)->{
            pasajero.nombre=event.getNombre();
        });
        apply((DatosPasajeroAgregado event)->{
           pasajero.dato = new Dato(event.getDatoId(), event.getCorrreo(),event.getDireccion(), event.getFechaNacimiento(), event.getTelefono());
        });
        apply((NombreModificado event) ->{
            pasajero.nombre=event.getNombre();
        });

        apply((TelefonoModificado event) ->{
            pasajero.dato.cambiartelefono(event.getTelefono());
        });


        apply((DestinoModificado event) ->{
            pasajero.tiquete.modificardestino(event.getDestino());
        });

        apply((EstadoCambiado event) ->{
            pasajero.tiquete.cambiarestado(event.getEstado());
        });

        apply((TipoDePagoModificado event) ->{
            pasajero.pago.modificartipodepago(event.getMetododepago());
        });

    }

}

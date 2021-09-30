package com.sofka.retoVueloDDD.domain.pasajero.entity;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retoVueloDDD.domain.genericvalues.Destino;
import com.sofka.retoVueloDDD.domain.genericvalues.Fecha;
import com.sofka.retoVueloDDD.domain.genericvalues.Nombre;
import com.sofka.retoVueloDDD.domain.genericvalues.Origen;
import com.sofka.retoVueloDDD.domain.pasajero.event.*;
import com.sofka.retoVueloDDD.domain.pasajero.values.*;

import java.util.List;
import java.util.Objects;

public class Pasajero extends AggregateEvent<PasajeroId> {

    protected Nombre nombre;
    protected Pago pago;
    protected Dato dato;
    protected Tiquete tiquete;

    public Pasajero(PasajeroId pasajeroId, Nombre nombre) {
        super(pasajeroId);
        appendChange(new PasajeroAgregado(pasajeroId, nombre)).apply();
    }

    private Pasajero(PasajeroId entityId) {
        super(entityId);
        subscribe(new PasajeroChange(this));
    }

    //factoria que permite crear el agregado

    public static Pasajero from(PasajeroId pasajeroId, List<DomainEvent> events){
        var pasajero=new Pasajero(pasajeroId);
        events.forEach(pasajero::applyEvent);
        return pasajero;
    }

    // Comportamientos
    public void AgregarDatosPasajero(DatoId datoId,Correo corrreo, Direccion direccion, Fecha fechaNacimiento, Telefono telefono ){
        Objects.requireNonNull(corrreo);
        Objects.requireNonNull(direccion);
        Objects.requireNonNull(fechaNacimiento);
        Objects.requireNonNull(telefono);
        appendChange(new DatosPasajeroAgregado(datoId, corrreo, direccion, fechaNacimiento, telefono)).apply();

    }
    public void modificarNombrePasajero(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreModificado(nombre)).apply();
    }

    public void modificarTelefonoPasajero(Telefono telefono){
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoModificado(telefono)).apply();
    }
    public void modificarOrigenDeTiquete(Origen origen){
        Objects.requireNonNull(origen);
        appendChange(new OrigenModificado(origen)).apply();
    }
    public void modificardestinodetiquete(Destino destino){
        Objects.requireNonNull(destino);
        appendChange(new DestinoModificado(destino)).apply();
    }

    public void cambiarEstadoDeTiquete( Estado estado){
        Objects.requireNonNull(estado);
        appendChange(new EstadoCambiado(estado)).apply();
    }
    public void modificarMetodoDePago(MetodoPago metodopago){
        Objects.requireNonNull(metodopago);
        appendChange(new TipoDePagoModificado(metodopago)).apply();
    }

   //Los Getter
    public Nombre Nombre() {
        return nombre;
    }

    public Pago Pago() {
        return pago;
    }

    public Dato Dato() {
        return dato;
    }

    public Tiquete Tiquete() {
        return tiquete;
    }
}
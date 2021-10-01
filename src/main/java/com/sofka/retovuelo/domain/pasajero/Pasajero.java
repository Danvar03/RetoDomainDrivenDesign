package com.sofka.retovuelo.domain.pasajero;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Destino;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.genericvalues.Origen;
import com.sofka.retovuelo.domain.pasajero.entity.DatosPersonal;
import com.sofka.retovuelo.domain.pasajero.entity.Pago;
import com.sofka.retovuelo.domain.pasajero.entity.TiqueteArereo;
import com.sofka.retovuelo.domain.pasajero.event.*;
import com.sofka.retovuelo.domain.pasajero.values.*;

import java.util.List;
import java.util.Objects;

public class Pasajero extends AggregateEvent<PasajeroId> {

    protected Nombre nombre;
    protected Pago pago;
    protected DatosPersonal datosPersonal;
    protected TiqueteArereo tiqueteArereo;

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
    public void agregarDatosPersonalesPasajero(DatoId datoId ,PasajeroId pasajeroId,Correo corrreo, Direccion direccion, Fecha fechaNacimiento, Telefono telefono ){
        Objects.requireNonNull(pasajeroId);
        Objects.requireNonNull(corrreo);
        Objects.requireNonNull(direccion);
        Objects.requireNonNull(fechaNacimiento);
        Objects.requireNonNull(telefono);
        appendChange(new DatosPersonalesPasajeroAgregado(pasajeroId, datoId, corrreo, direccion, fechaNacimiento, telefono)).apply();

    }
    public void agregarTiqueteAereo(TiqueteId tiqueteId, Origen origen, Asiento asiento, Destino destino, Estado estado ){
        Objects.requireNonNull(tiqueteId);
        Objects.requireNonNull(origen);
        Objects.requireNonNull(asiento);
        Objects.requireNonNull(destino);
        Objects.requireNonNull(estado);
        appendChange(new TiqueteAereoAgregado(tiqueteId,origen,  asiento,  destino, estado)).apply();
    }

    public void actualizarDatosPersonalesPasajero(DatoId datoId ,PasajeroId pasajeroId,Correo corrreo, Direccion direccion, Fecha fechaNacimiento, Telefono telefono ) {
        Objects.requireNonNull(pasajeroId);
        Objects.requireNonNull(corrreo);
        Objects.requireNonNull(direccion);
        Objects.requireNonNull(fechaNacimiento);
        Objects.requireNonNull(telefono);
        appendChange(new DatosPersonalesPasajeroAgregado(pasajeroId, datoId, corrreo, direccion, fechaNacimiento, telefono)).apply();
    }
    public void modificarNombrePasajero(PasajeroId pasajeroId,Nombre nombre){
        Objects.requireNonNull(pasajeroId);
        Objects.requireNonNull(nombre);
        appendChange(new NombreModificado(pasajeroId, nombre)).apply();
    }

    public void modificarTelefonoPasajero(Telefono telefono){
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoModificado(telefono)).apply();
    }
    public void modificarOrigenDeTiquete(Origen origen){
        Objects.requireNonNull(origen);
        appendChange(new OrigenModificado(origen)).apply();
    }
    public void modificardestinodetiquete(PasajeroId pasajeroId,Destino destino){
        Objects.requireNonNull(pasajeroId);
        Objects.requireNonNull(destino);

        appendChange(new DestinoModificado( pasajeroId,destino)).apply();
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

    public DatosPersonal Dato() {
        return datosPersonal;
    }

    public TiqueteArereo Tiquete() {
        return tiqueteArereo;
    }
}
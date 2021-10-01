package com.sofka.retovuelo.domain.vuelo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.vuelo.entity.Avion;
import com.sofka.retovuelo.domain.vuelo.entity.Piloto;
import com.sofka.retovuelo.domain.vuelo.entity.Trayecto;
import com.sofka.retovuelo.domain.vuelo.event.*;
import com.sofka.retovuelo.domain.vuelo.values.*;

import java.util.List;
import java.util.Objects;

public class Vuelo extends AggregateEvent<VueloId> {

    protected VueloId vueloId;
    protected Nombre nombrevuelo;
    protected Trayecto trayecto;
    protected Duracion duracion;
    protected Fecha fecha;
    protected Piloto piloto;
    protected Avion avion;
    protected Aerolinea aerolinea;

    public Vuelo(VueloId vueloId, Aerolinea aerolinea, Duracion duracion, Fecha fechahora) {
        super(vueloId);
        appendChange(new VueloCreado(vueloId, aerolinea, duracion, fechahora)).apply();
    }

    private Vuelo(VueloId vueloId) {
        super(vueloId);
        subscribe(new VueloChange(this));
    }

    //factoria que permite crear el agregado
    public static Vuelo from(VueloId entityId, List<DomainEvent> events) {
        var vuelo = new Vuelo(entityId);
        events.forEach(vuelo::applyEvent);
        return vuelo;
    }

    //comportamientos

    public void cambiarDuracionDelVuelo(Duracion duracion) {
        Objects.requireNonNull(duracion);
        appendChange(new DuracionCambiada(duracion)).apply();
    }

    public void cambiarFechayHoraDelVuelo(Fecha fecha) {
        Objects.requireNonNull(fecha);
        appendChange(new FechayHoraCambiada(fecha)).apply();
    }

    public void cambiarEstadoDeAeropuerto(Estado estado) {
        Objects.requireNonNull(estado);
        appendChange(new EstadoCambiadoDelAeropuerto(estado)).apply();
    }

    public void cambiarRutaDelAvion(Ruta ruta) {
        Objects.requireNonNull(ruta);
        appendChange(new RutaCambiada(ruta)).apply();
    }

    public void cambiarTurnoDePiloto(Turno turno) {
        Objects.requireNonNull(turno);
        appendChange(new TurnoCambiado(turno)).apply();
    }

    public void cambiarNombrePiloto(Nombre nombre) {
        Objects.requireNonNull(nombre);
        appendChange(new NombrePilotoCambiado(nombre)).apply();
    }

    //propiedades

    public Nombre Nombrevuelo() {
        return nombrevuelo;
    }

    public Fecha Fecha() {
        return fecha;
    }

    public Duracion Duracion() {
        return duracion;
    }

    public Trayecto Trayecto() {
        return trayecto;
    }

    public Avion Avion() {
        return avion;
    }

    public Piloto Piloto() {
        return piloto;
    }

    public Aerolinea Aerolinea() {
        return aerolinea;
    }
}

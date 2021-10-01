package com.sofka.retovuelo.domain.vuelo;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.retovuelo.domain.vuelo.event.*;

public class VueloChange extends EventChange {

    public VueloChange(Vuelo vuelo) {
        apply((VueloCreado event) -> {

            vuelo.aerolinea = event.getAerolinea();
            vuelo.duracion = event.getDuracion();
            vuelo.fecha = event.getFecha();
        });

        apply((DuracionCambiada event) -> {
            vuelo.duracion = event.getDuracion();
        });

        apply((FechayHoraCambiada event) -> {
            vuelo.fecha = event.getFecha();
        });

        apply((RutaCambiada event) -> {
            vuelo.avion.cambiarruta(event.getRuta());
        });

        apply((TurnoCambiado event) -> {
            vuelo.piloto.cambiarturno(event.getTurno());
        });

        apply((NombrePilotoCambiado event) -> {
            vuelo.piloto.cambiarnormbrepiloto(event.getnombrepiloto());
        });

    }
}

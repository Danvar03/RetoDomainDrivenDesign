package com.sofka.retovuelo.domain.vuelo.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Nombre;


public class NombrePilotoCambiado extends DomainEvent {

    private final Nombre nombrepiloto;

    public NombrePilotoCambiado(Nombre nombrepiloto) {
        super("aerolinea.ventatiquetes.domain.vuelo.cambiarnombrepiloto");
        this.nombrepiloto=nombrepiloto;
    }

    public Nombre getnombrepiloto() {
        return nombrepiloto;
    }
}

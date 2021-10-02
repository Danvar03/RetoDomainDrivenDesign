package com.sofka.retovuelo.domain.vuelo.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.vuelo.values.Aerolinea;
import com.sofka.retovuelo.domain.vuelo.values.Duracion;
import com.sofka.retovuelo.domain.vuelo.values.VueloId;


public class VueloCreado extends DomainEvent {
    private final VueloId vueloId;
    private final Aerolinea aerolinea;
    private final Duracion duracion;
    private final Fecha fecha;


    public VueloCreado(VueloId vueloId,Aerolinea aerolinea,  Duracion duracion, Fecha fechahora) {
        super("ventatiquetes.vuelo.vuelocreado");
        this.aerolinea = aerolinea;
        this.vueloId = vueloId;
        this.duracion = duracion;
        this.fecha = fechahora;
    }


    public VueloId getVueloId() {
        return vueloId;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public Fecha getFecha() {
        return fecha;
    }
}

package com.sofka.retovuelo.domain.vuelo.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.vuelo.values.Duracion;
import com.sofka.retovuelo.domain.vuelo.values.VueloId;


public class VueloCreado extends DomainEvent {

    private final VueloId vueloId;
    private final Nombre nombrevuelo;
    private final Duracion duracion;
    private final Fecha fechahora;


    public VueloCreado( VueloId vueloId, Nombre nombrevuelo, Duracion duracion, Fecha fechahora) {
        super("ventatiquetes.vuelo.vuelocreado");
        this.vueloId = vueloId;
        this.nombrevuelo = nombrevuelo;
        this.duracion = duracion;
        this.fechahora = fechahora;
    }

    public VueloId getVueloId() {
        return vueloId;
    }

    public Nombre getNombrevuelo() {
        return nombrevuelo;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public Fecha getFechahora() {
        return fechahora;
    }
}

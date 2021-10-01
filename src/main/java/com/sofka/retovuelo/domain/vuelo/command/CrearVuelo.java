package com.sofka.retovuelo.domain.vuelo.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.vuelo.values.Aerolinea;
import com.sofka.retovuelo.domain.vuelo.values.Duracion;
import com.sofka.retovuelo.domain.vuelo.values.VueloId;


public class CrearVuelo extends Command {

    private final VueloId vueloId;
    private final Aerolinea aerolinea;

    private final Duracion duracion;
    private final Fecha fecha;


    public CrearVuelo(VueloId vueloId, Aerolinea aerolinea, Duracion duracion, Fecha fechahora) {

        this.vueloId = vueloId;
        this.aerolinea = aerolinea;

        this.duracion = duracion;
        this.fecha = fechahora;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public VueloId getVueloId() {
        return vueloId;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public Fecha getFecha() {
        return fecha;
    }
}

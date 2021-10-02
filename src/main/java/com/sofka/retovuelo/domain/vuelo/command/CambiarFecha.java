package com.sofka.retovuelo.domain.vuelo.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.vuelo.values.VueloId;


public class CambiarFecha extends Command {
    private  final VueloId vueloId;
    private final Fecha fecha;


    public CambiarFecha(VueloId vueloId, Fecha fecha) {
        this.vueloId = vueloId;
        this.fecha = fecha;
    }

    public VueloId getVueloId() {
        return vueloId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}

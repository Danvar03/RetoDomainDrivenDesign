package com.sofka.retovuelo.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.pasajero.values.MetodoPago;

public class TipoDePagoModificado extends DomainEvent {
    private final MetodoPago metododepago;


    public TipoDePagoModificado(MetodoPago metododepago) {
        super("aerolinea.ventatiquetes.domain.pasajero.tipodepagomodificado");
        this.metododepago = metododepago;
    }

    public MetodoPago getMetododepago() {
        return metododepago;
    }
}

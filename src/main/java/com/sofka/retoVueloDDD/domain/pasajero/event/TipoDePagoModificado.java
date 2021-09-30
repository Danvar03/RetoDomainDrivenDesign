package com.sofka.retoVueloDDD.domain.pasajero.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retoVueloDDD.domain.pasajero.values.MetodoPago;

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

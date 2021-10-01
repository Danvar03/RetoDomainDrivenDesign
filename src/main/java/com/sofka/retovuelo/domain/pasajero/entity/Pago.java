package com.sofka.retovuelo.domain.pasajero.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.retovuelo.domain.pasajero.values.MetodoPago;
import com.sofka.retovuelo.domain.pasajero.values.PagoId;

import java.util.Objects;

public class Pago extends Entity<PagoId> {

    private MetodoPago metododepago;

    public Pago(PagoId entityId, MetodoPago metododepago) {
        super(entityId);
        this.metododepago = metododepago;
    }

    //comportamientos
    public void modificartipodepago(MetodoPago metodopago) {
        this.metododepago = Objects.requireNonNull(metododepago);
    }

    //propiedades
    public MetodoPago Metododepago() {
        return metododepago;
    }
}

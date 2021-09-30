package com.sofka.retoVueloDDD.domain.pasajero.values;

import co.com.sofka.domain.generic.Identity;

public class PagoId extends Identity {

    public PagoId() {

    }

    public PagoId(String id) {
        super(id);
    }

    public static PagoId of(String id) {
        return new PagoId(id);
    }
}

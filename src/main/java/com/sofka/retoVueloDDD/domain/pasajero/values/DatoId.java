package com.sofka.retoVueloDDD.domain.pasajero.values;

import co.com.sofka.domain.generic.Identity;

public class DatoId extends Identity {

    public DatoId() {

    }

    public DatoId(String id) {
        super(id);
    }

    public static DatoId of(String id) {
        return new DatoId(id);
    }
}

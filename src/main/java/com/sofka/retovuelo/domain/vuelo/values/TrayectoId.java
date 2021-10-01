package com.sofka.retovuelo.domain.vuelo.values;

import co.com.sofka.domain.generic.Identity;

public class TrayectoId extends Identity {

    public TrayectoId() {

    }

    public TrayectoId(String id) {
        super(id);
    }

    public static TrayectoId of(String id) {
        return new TrayectoId(id);
    }
}

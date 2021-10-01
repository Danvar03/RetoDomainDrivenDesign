package com.sofka.retovuelo.domain.pasajero.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {

    private final String value;

    public Telefono(String value) {
        this.value = Objects.requireNonNull(value);
        if (!this.value.matches("^[0-9-\\+]")) {
            throw new IllegalArgumentException("Telefono no valido");
        }
        if(value.length()<7){
            throw new IllegalArgumentException("El telefono no puede ser menor a 8 caracteres");
        }

        if(value.length()>15){
            throw new IllegalArgumentException("El telefono no puede ser mayor a 15 caracteres");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var telefono = (Telefono) o;
        return Objects.equals(value, telefono.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }
}

package com.sofka.retovuelo.domain.vuelo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Escala implements ValueObject<String> {

    private final String value;

    public Escala(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El nombre de la escala esta vacia");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Escala escala = (Escala) o;
        return Objects.equals(value, escala.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
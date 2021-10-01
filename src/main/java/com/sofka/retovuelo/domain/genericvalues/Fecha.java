package com.sofka.retovuelo.domain.genericvalues;

import co.com.sofka.domain.generic.ValueObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Fecha implements ValueObject<Date> {
    private final Date value;

    public Fecha(Date value){
        this.value = Objects.requireNonNull(value);
        if(this.value.equals("")){
            throw new IllegalArgumentException("la fecha no puede estar vacia");
        }
    }

    public Date value(){
        return value;
    }

    public String fechaAndHora() {
        Date dateandhours = new Date();
        SimpleDateFormat Format = new SimpleDateFormat("YYYY/MM/DD '-' HH:mm:ss");
        return Format.format(dateandhours);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha fecha = (Fecha) o;
        return Objects.equals(value, fecha.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

package com.sofka.retovuelo.usecasetest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.vuelo.command.CrearVuelo;
import com.sofka.retovuelo.domain.vuelo.event.VueloCreado;
import com.sofka.retovuelo.domain.vuelo.values.Aerolinea;
import com.sofka.retovuelo.domain.vuelo.values.Duracion;
import com.sofka.retovuelo.domain.vuelo.values.VueloId;
import com.sofka.retovuelo.usecase.vuelo.CrearVueloCaseUse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

@ExtendWith(MockitoExtension.class)
public class CrearVueloCaseUseTest {
    @Test
    @DisplayName("Pasa test agregar pasajero")
    void CrearVuelo() {
        var command = new CrearVuelo(
                VueloId.of("xxx2"),
                new Aerolinea("Avianca"),
                new Duracion("50 minutos"),
                new Fecha("2002-09-02"));

        var useCase = new CrearVueloCaseUse();
        // Act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (VueloCreado) events.get(0);

        Assertions.assertTrue(Objects.nonNull(event.getVueloId().value()));
        Assertions.assertEquals("Avianca", event.getAerolinea().value());
        Assertions.assertEquals("50 minutos", event.getDuracion().value());
        Assertions.assertEquals("2002-09-02", event.getFecha().value());




    }

}

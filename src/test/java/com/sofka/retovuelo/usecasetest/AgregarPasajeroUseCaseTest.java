package com.sofka.retovuelo.usecasetest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.pasajero.command.AgregarPasajero;
import com.sofka.retovuelo.domain.pasajero.event.PasajeroAgregado;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;
import com.sofka.retovuelo.usecase.pasajero.AgregarPasajeroUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Objects;

@ExtendWith(MockitoExtension.class)
class AgregarPasajeroUseCaseTest {


    @Test
    @DisplayName("Pasa test agregar vuelo")
    void AgregarPasajero(){
        var command = new AgregarPasajero(
                PasajeroId.of("xxx-xx3"),
                new Nombre("Sara"));

        var  useCase = new AgregarPasajeroUseCase();
        // Act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (PasajeroAgregado) events.get(0);

        Assertions.assertTrue(Objects.nonNull(event.getPasajeroId().value()));
        Assertions.assertEquals("Saraa", event.getNombre().value());

    }

}


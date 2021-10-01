package com.sofka.retovuelo.usecasetest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.pasajero.command.ModificarTelefono;
import com.sofka.retovuelo.domain.pasajero.event.PasajeroAgregado;
import com.sofka.retovuelo.domain.pasajero.event.TelefonoModificado;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;
import com.sofka.retovuelo.domain.pasajero.values.Telefono;
import com.sofka.retovuelo.usecase.pasajero.ModificarNombrePasajeroUseCase;

import com.sofka.retovuelo.usecase.pasajero.ModificarTelefonoPasajeroUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ModificarTelefonoPasajeroUseCaseTest {

    private ModificarTelefonoPasajeroUseCase modificarTelefonoPasajeroUseCase;

    @Mock
    private DomainEventRepository repository;


    @BeforeEach
    public void setup(){
        modificarTelefonoPasajeroUseCase= new ModificarTelefonoPasajeroUseCase();
        repository=mock(DomainEventRepository.class);
        modificarTelefonoPasajeroUseCase.addRepository(repository);
    }


    @Test
    @DisplayName("Pasa test de modificar nombre de pasajero")
    void modificarTelefonoHappyPath() {
        //arrage
        var command = new ModificarTelefono(
                PasajeroId.of("xxx-xxx"),
                new Telefono("3152417147"));


        when(repository.getEventsBy(any())).thenReturn(events());

        var response= UseCaseHandler.getInstance().
                setIdentifyExecutor("xxx-xxx").syncExecutor(
                        modificarTelefonoPasajeroUseCase, new RequestCommand<>(command)
                ).orElseThrow();

        var event=(TelefonoModificado)response.getDomainEvents().get(0);

        //Asserts:
        Assertions.assertEquals("3152417147", event.getTelefono().value());


    }

    private List<DomainEvent> events() {
        return List.of(new PasajeroAgregado(
                new PasajeroId("xxx-xxx1"),
                new Nombre("3152417147")));
    }
}

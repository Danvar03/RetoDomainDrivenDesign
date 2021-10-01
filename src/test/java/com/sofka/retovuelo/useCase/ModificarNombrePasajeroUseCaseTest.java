package com.sofka.retovuelo.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.pasajero.command.ModificarNombre;
import com.sofka.retovuelo.domain.pasajero.event.NombreModificado;
import com.sofka.retovuelo.domain.pasajero.event.PasajeroAgregado;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;
import com.sofka.retovuelo.usecase.pasajero.ModificarNombrePasajeroUseCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModificarNombrePasajeroUseCaseTest {

    private ModificarNombrePasajeroUseCase modificarNombrePasajeroUseCase;
    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        modificarNombrePasajeroUseCase= new ModificarNombrePasajeroUseCase();
        repository=mock(DomainEventRepository.class);
        modificarNombrePasajeroUseCase.addRepository(repository);
    }

    @Test
    @DisplayName("Pasa test de modificar nombre de pasajero")
    void modificarNombreHappyPath(){
        //arrage
        var command = new ModificarNombre(
                PasajeroId.of("xxx-xxx"),
                new Nombre("Daniela Vargas Mendoza")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        //Act
        var response= UseCaseHandler.getInstance().
                setIdentifyExecutor("xxx-xxx").syncExecutor(
                        modificarNombrePasajeroUseCase, new RequestCommand<>(command)
                ).orElseThrow();

        var event=(NombreModificado)response.getDomainEvents().get(0);

        //Asserts:
        Assertions.assertEquals("Daniela Vargas Mendoza", event.getNombre().value());
        Assertions.assertEquals("aerolinea.ventatiquetes.domain.pasajero.nombrecambiado", event.type);

    }
    private List<DomainEvent> events() {
        return List.of(new PasajeroAgregado(
                new PasajeroId("xxx-xxx1"),
                new Nombre("  Julieta Vargas Mendoza")


        ));
    }

}
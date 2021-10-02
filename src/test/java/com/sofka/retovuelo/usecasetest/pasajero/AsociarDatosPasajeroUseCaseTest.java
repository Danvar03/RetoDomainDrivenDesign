package com.sofka.retovuelo.usecasetest.pasajero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.pasajero.command.AsociarDatosPersonalesPasajero;
import com.sofka.retovuelo.domain.pasajero.event.DatosPersonalesPasajeroAsociados;
import com.sofka.retovuelo.domain.pasajero.event.PasajeroAgregado;

import com.sofka.retovuelo.domain.pasajero.values.*;
import com.sofka.retovuelo.usecase.pasajero.AsociarDatosPasajeroUseCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class AsociarDatosPasajeroUseCaseTest {


    private AsociarDatosPasajeroUseCase asociarDatosPasajeroUseCase;


    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        asociarDatosPasajeroUseCase = new AsociarDatosPasajeroUseCase();
        asociarDatosPasajeroUseCase.addRepository(repository);
    }


    @Test
    @DisplayName("Pasa test datos de pasajero agregados agregar pasajero")
    void AgregarDatosPersonalesPasajero() {
        var nombre = new Nombre("Daniela Vargas Mendoza");
        var datoid = DatoId.of("xxx-xx3");
        var pasajeroId = PasajeroId.of("xxx-xx3");
        var correo = new Correo("daniela@vargas.com");
        var direccion = new Direccion("Carrera 30#25-64");
        var fecha = new Fecha("2021-09-02");
        var telefono = new Telefono("22222222222");

        var command = new AsociarDatosPersonalesPasajero(
                datoid,
                pasajeroId,
                correo,
                direccion,
                fecha,
                telefono);


        Mockito.when(repository.getEventsBy(pasajeroId.value())).thenReturn(events(pasajeroId, nombre));
        //Act
        var events = UseCaseHandler.getInstance().
                setIdentifyExecutor(pasajeroId.value()).syncExecutor(
                        asociarDatosPasajeroUseCase, new RequestCommand<>(command)
                ).orElseThrow()
                .getDomainEvents();

        var event = (DatosPersonalesPasajeroAsociados) events.get(0);

        Assertions.assertEquals("xxx-xx3", event.aggregateRootId());
        Assertions.assertEquals("daniela@vargas.com", event.getCorrreo().value());
        Assertions.assertEquals("Carrera 30#25-64", event.getDireccion().value());
        Assertions.assertEquals("2021-09-02", event.getFechaNacimiento().value());
        Assertions.assertEquals("22222222222", event.getTelefono().value());
       Mockito.verify(repository).getEventsBy(pasajeroId.value());


    }

    private List<DomainEvent> events(PasajeroId pasajeroId, Nombre nombre) {
        return List.of(
                new PasajeroAgregado(pasajeroId, nombre)


        );


    }


}

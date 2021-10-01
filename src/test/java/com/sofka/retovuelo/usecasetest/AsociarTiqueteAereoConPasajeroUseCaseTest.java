package com.sofka.retovuelo.usecasetest;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Destino;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.genericvalues.Origen;
import com.sofka.retovuelo.domain.pasajero.command.AsociarTiqueteAereo;
import com.sofka.retovuelo.domain.pasajero.event.PasajeroAgregado;
import com.sofka.retovuelo.domain.pasajero.event.TiqueteAereoAsociado;
import com.sofka.retovuelo.domain.pasajero.values.Asiento;
import com.sofka.retovuelo.domain.pasajero.values.Estado;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;
import com.sofka.retovuelo.domain.pasajero.values.TiqueteId;
import com.sofka.retovuelo.usecase.pasajero.AsociarTiqueteAereoConPasajeroUseCase;
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
class AsociarTiqueteAereoConPasajeroUseCaseTest {
    private AsociarTiqueteAereoConPasajeroUseCase asociarTiqueteAereoConPasajeroUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        asociarTiqueteAereoConPasajeroUseCase = new AsociarTiqueteAereoConPasajeroUseCase();
        asociarTiqueteAereoConPasajeroUseCase.addRepository(repository);
    }


    @Test
    @DisplayName("Pasa test de modificar nombre de pasajero")
    void asociarTiquete() {
        //arrage
        var pasajeroId = PasajeroId.of("xxx-xx3");
        var nombre = new Nombre("Daniela Vargas Mendoza");
        var tiqueteId = TiqueteId.of("yyyy-yyy");
        var origen = new Origen("Bogota");
        var asiento = new Asiento("201");
        var destino = new Destino("Medellin");
        var estado = new Estado("Listo");
        var command = new AsociarTiqueteAereo(
                pasajeroId,
                tiqueteId,
                origen,
                asiento,
                destino,
                estado
        );

        Mockito.when(repository.getEventsBy("xxx-xx3")).thenReturn(events(pasajeroId, nombre));
        //Act
        var events = UseCaseHandler.getInstance().
                setIdentifyExecutor("xxx-xx3").syncExecutor(
                        asociarTiqueteAereoConPasajeroUseCase, new RequestCommand<>(command)
                ).orElseThrow()
                .getDomainEvents();

        var event = (TiqueteAereoAsociado) events.get(0);

        Assertions.assertEquals("xxx-xx3", event.aggregateRootId());
        Assertions.assertEquals("Bogota", event.getOrigen().value());
        Assertions.assertEquals("201", event.getAsiento().value());
        Assertions.assertEquals("Medellin", event.getDestino().value());
        Assertions.assertEquals("Listo", event.getEstado().value());
        Mockito.verify(repository).getEventsBy(pasajeroId.value());


    }

    private List<DomainEvent> events(PasajeroId pasajeroId, Nombre nombre) {
        return List.of(
                new PasajeroAgregado(pasajeroId, nombre)


        );


    }


}







package com.sofka.retovuelo.usecasetest.vuelo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;

import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.vuelo.command.AgregarPiloto;
import com.sofka.retovuelo.domain.vuelo.event.PilotoAgregado;
import com.sofka.retovuelo.domain.vuelo.event.VueloCreado;
import com.sofka.retovuelo.domain.vuelo.values.*;


import com.sofka.retovuelo.usecase.vuelo.AsignarPilotoUseCase;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
class AsignarPilotoUseCaseTest {
    private AsignarPilotoUseCase asignarPilotoUseCase;


    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        asignarPilotoUseCase = new AsignarPilotoUseCase();
        asignarPilotoUseCase.addRepository(repository);
    }


    @Test
    @DisplayName("Pasa test de Asignar Piloto")
    void agregarPiloto() {
        var aerolinea = new Aerolinea("Avianca");
        var duracion = new Duracion("50 minutos");
        var fecha = new Fecha("2002-09-02");
        var vueloId = VueloId.of("xxx2");
        var pilotoId = PilotoId.of("zzz-zzz");
        var nombrepiloto = new Nombre("Andres Felipe Cuellar");
        var turno = new Turno("Noche");

        var command = new AgregarPiloto(
                vueloId,
                pilotoId,
                nombrepiloto,
                turno
        );
        var useCase = new AsignarPilotoUseCase();
        // Act
        Mockito.when(repository.getEventsBy(vueloId.value())).thenReturn(events(vueloId, aerolinea, duracion, fecha));


        //Act
        var events = UseCaseHandler.getInstance().
                setIdentifyExecutor(vueloId.value()).syncExecutor(
                        asignarPilotoUseCase, new RequestCommand<>(command)
                ).orElseThrow()
                .getDomainEvents();
        var event = (PilotoAgregado) events.get(0);

        Assertions.assertTrue(Objects.nonNull(event.getPilotoId().value()));
        Assertions.assertEquals("Andres Felipe Cuellar", event.getNombre().value());
        Assertions.assertEquals("Noche", event.getTurno().value());
        Mockito.verify(repository).getEventsBy(vueloId.value());



    }

    private List<DomainEvent> events(VueloId vueloId, Aerolinea aerolinea, Duracion duracion, Fecha fecha) {
        return List.of(
                new VueloCreado(vueloId, aerolinea, duracion, fecha)


        );


    }
}

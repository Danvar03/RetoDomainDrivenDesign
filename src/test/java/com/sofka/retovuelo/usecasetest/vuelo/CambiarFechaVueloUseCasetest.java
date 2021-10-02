package com.sofka.retovuelo.usecasetest.vuelo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.vuelo.command.CambiarFecha;
import com.sofka.retovuelo.domain.vuelo.event.FechayHoraCambiada;
import com.sofka.retovuelo.domain.vuelo.event.VueloCreado;
import com.sofka.retovuelo.domain.vuelo.values.Aerolinea;
import com.sofka.retovuelo.domain.vuelo.values.Duracion;
import com.sofka.retovuelo.domain.vuelo.values.VueloId;

import com.sofka.retovuelo.usecase.vuelo.CambiarFechaVueloUseCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;


public class CambiarFechaVueloUseCasetest {


    // Se aplica mock
    @Mock
    private DomainEventRepository repository;


    //Inyectando


    @Test
    @DisplayName("Pasa test de cambiar fecha")
    void cambiarFecha() {
        var aggregateId = "0007";
        //arrage

        var vueloId = VueloId.of("xxx2");
        var aerolinea = new Aerolinea("Avianca");
        var duracion = new Duracion("50 minutos");
        var fecha = new Fecha("2002-09-02");


        var command = new CambiarFecha(
                vueloId,
               new Fecha("2000-10-02")
        );

        //Act
        var useCase = new CambiarFechaVueloUseCase();


        Mockito.when(repository.getEventsBy(vueloId.value())).thenReturn(events(vueloId, aerolinea, duracion, fecha));

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(vueloId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (FechayHoraCambiada)events.get(0);
        Assertions.assertEquals("2002-09-02", event.getFecha().value());

    }

    private List<DomainEvent> events(VueloId vueloId,Aerolinea aerolinea, Duracion duracion, Fecha fecha) {
        return List.of(
                new VueloCreado(vueloId,aerolinea, duracion, fecha)


        );


    }


}

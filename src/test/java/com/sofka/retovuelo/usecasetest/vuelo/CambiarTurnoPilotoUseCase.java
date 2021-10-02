package com.sofka.retovuelo.usecasetest.vuelo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.vuelo.command.CambiarFecha;
import com.sofka.retovuelo.domain.vuelo.event.TurnoCambiado;
import com.sofka.retovuelo.domain.vuelo.event.VueloCreado;
import com.sofka.retovuelo.domain.vuelo.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class CambiarTurnoPilotoUseCase {
    // Se aplica mock
    @Mock
    private DomainEventRepository repository;


    @Test
    @DisplayName("Pasa test de cambiar turno piloto")
    void cambiarFecha() {
        var aggregateId = "0007";
        //arrage
        var aerolinea = new Aerolinea("Avianca");
        var duracion = new Duracion("50 minutos");
        var fecha = new Fecha("2002-09-02");
        var vueloId = VueloId.of("xxx2");

        var pilotoId = PilotoId.of("zzz-zzz");
        var nombrepiloto = new Nombre("Andres Felipe Cuellar");
        var turno = new Turno("Noche");

        var command = new TurnoCambiado(
                new Turno("Diuerno")
        );

        //Act
        var useCase = new CambiarTurnoPilotoUseCase();


    }


}
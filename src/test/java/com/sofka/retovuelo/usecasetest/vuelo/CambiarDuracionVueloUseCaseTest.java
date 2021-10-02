package com.sofka.retovuelo.usecasetest.vuelo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.retovuelo.domain.genericvalues.Fecha;
import com.sofka.retovuelo.domain.genericvalues.Nombre;
import com.sofka.retovuelo.domain.pasajero.event.NombreModificado;
import com.sofka.retovuelo.domain.pasajero.event.PasajeroAgregado;
import com.sofka.retovuelo.domain.pasajero.values.PasajeroId;
import com.sofka.retovuelo.domain.vuelo.command.CambiarDuracion;
import com.sofka.retovuelo.domain.vuelo.event.DuracionCambiada;
import com.sofka.retovuelo.domain.vuelo.event.VueloCreado;
import com.sofka.retovuelo.domain.vuelo.values.Aerolinea;
import com.sofka.retovuelo.domain.vuelo.values.Duracion;
import com.sofka.retovuelo.domain.vuelo.values.VueloId;
import com.sofka.retovuelo.usecase.vuelo.CambiarDuracionVueloCaseUse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class CambiarDuracionVueloUseCaseTest {

    private CambiarDuracionVueloCaseUse cambiarDuracionVuelo;

    // Se aplica mock
    @Mock
    private DomainEventRepository repository;


    //Inyectando
    @BeforeEach
    public void setup() {
        cambiarDuracionVuelo = new CambiarDuracionVueloCaseUse();
        cambiarDuracionVuelo.addRepository(repository);
    }

    @Test
    @DisplayName("Pasa test de cambiar duracion")
    void cambiarDuracionVuelo() {
        //arrage
        var aerolinea = new Aerolinea("Avianca");
        var vueloId = VueloId.of("xxx2");
        var fecha = new Fecha("2002-09-02");
        var duracion = new Duracion("50 minutos");

        var command = new CambiarDuracion(
                vueloId,
               new Duracion("240 minutos")
        );

        Mockito.when(repository.getEventsBy(vueloId.value())).thenReturn(events(vueloId, aerolinea, duracion, fecha));

        //Act
        var response = UseCaseHandler.getInstance().
                setIdentifyExecutor("xxx2").syncExecutor(
                        cambiarDuracionVuelo, new RequestCommand<>(command)
                ).orElseThrow();

        var event = (DuracionCambiada) response.getDomainEvents().get(0);

        //Asserts:
        Assertions.assertEquals("90 minutos", event.getDuracion().value());


    }

    private List<DomainEvent> events(VueloId vueloId, Aerolinea aerolinea, Duracion duracion, Fecha fecha) {
        return List.of(
                new VueloCreado(vueloId, aerolinea, duracion, fecha)


        );

    }


}

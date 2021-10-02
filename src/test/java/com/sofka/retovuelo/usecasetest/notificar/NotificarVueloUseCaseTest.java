package com.sofka.retovuelo.usecasetest.notificar;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.retovuelo.domain.vuelo.event.RutaCambiada;
import com.sofka.retovuelo.domain.vuelo.values.Ruta;
import com.sofka.retovuelo.usecase.notificar.NotificarVueloUseCase;
import com.sofka.retovuelo.usecase.notificar.PilotoService;
import com.sofka.retovuelo.usecase.notificar.SenderEmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class NotificarVueloUseCaseTest {

    private NotificarVueloUseCase notificarVueloUseCase;

    private PilotoService pilotoService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup(){
        notificarVueloUseCase = new NotificarVueloUseCase();
        pilotoService = mock(PilotoService.class);
        senderEmailService = mock(SenderEmailService.class);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(pilotoService);
        builder.addService(senderEmailService);

        notificarVueloUseCase.addServiceBuilder(builder);
    }

    @Test
    void notificarVueloHappyPath(){
        var event = new RutaCambiada(
                new Ruta("Norte del país")
        );
        when(pilotoService.getEmailByPiloto(any())).thenReturn("piloto@gmail.com");
        doNothing().when(senderEmailService).sendEmail(any(),anyString());

        UseCaseHandler.getInstance()
                .syncExecutor(
                        notificarVueloUseCase,
                        new TriggeredEvent<>(event)
                );

        verify(pilotoService).getEmailByPiloto(any());
        verify(senderEmailService).sendEmail(any(),anyString());
    }

}
package com.sofka.retovuelo.usecasetest.notificar;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.retovuelo.domain.pasajero.event.TipoDePagoModificado;
import com.sofka.retovuelo.domain.pasajero.values.MetodoPago;
import com.sofka.retovuelo.usecase.notificar.NotificarTelefonoUseCase;
import com.sofka.retovuelo.usecase.notificar.PasajeroService;
import com.sofka.retovuelo.usecase.notificar.SenderEmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class NotificarTelefonoUseCaseTest {

    private NotificarTelefonoUseCase notificarTelefonoUseCase;

    private PasajeroService pasajeroService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup(){
        notificarTelefonoUseCase = new NotificarTelefonoUseCase();
        pasajeroService = mock(PasajeroService.class);
        senderEmailService = mock(SenderEmailService.class);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(pasajeroService);
        builder.addService(senderEmailService);

        notificarTelefonoUseCase.addServiceBuilder(builder);
    }

    @Test
    void notificarTipodePadoHappyPath(){
        var event = new TipoDePagoModificado(
                new MetodoPago("PSE")
        );
        when(pasajeroService.getEmailByPasajero(any())).thenReturn("pasajero@gmail.com");
        doNothing().when(senderEmailService).sendEmail(any(),anyString());

        UseCaseHandler.getInstance()
                .syncExecutor(
                        notificarTelefonoUseCase,
                        new TriggeredEvent<>(event)
                );

        verify(pasajeroService).getEmailByPasajero(any());
        verify(senderEmailService).sendEmail(any(),anyString());
    }

}
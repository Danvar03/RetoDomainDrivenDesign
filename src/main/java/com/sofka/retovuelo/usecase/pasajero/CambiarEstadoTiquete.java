package com.sofka.retovuelo.usecase.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.retovuelo.domain.pasajero.Pasajero;
import com.sofka.retovuelo.domain.pasajero.command.CambiarEstadoDeTiquete;


public class CambiarEstadoTiquete extends UseCase<RequestCommand<CambiarEstadoDeTiquete>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarEstadoDeTiquete> cambiarEstadoDeTiqueteRequestCommand) {
        var command = cambiarEstadoDeTiqueteRequestCommand.getCommand();
        var nombre = Pasajero.from(command.getPasajeroId(),retrieveEvents(command.getPasajeroId().value()));
        nombre.cambiarEstadoDeTiquete(command.getPasajeroId(),command.getEstado());
        emit().onResponse(new ResponseEvents(nombre.getUncommittedChanges()));
    }
}

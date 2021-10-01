package com.sofka.retovuelo.usecase.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.retovuelo.domain.pasajero.command.ModificarDestino;
import com.sofka.retovuelo.domain.pasajero.Pasajero;

public class ModificardestinodetiqueteUseCase extends UseCase<RequestCommand<ModificarDestino>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarDestino> modificarDestinoDeTiqueteRequestCommand) {
        var command = modificarDestinoDeTiqueteRequestCommand.getCommand();
        var destino = Pasajero.from(command.getPasajeroId(),retrieveEvents(command.getPasajeroId().value()));
        destino.modificardestinodetiquete(command.getPasajeroId(), command.getDestino());
        emit().onResponse(new ResponseEvents(destino.getUncommittedChanges()));
    }
}

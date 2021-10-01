package com.sofka.retovuelo.usecase.pasajero;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.retovuelo.domain.pasajero.Pasajero;
import com.sofka.retovuelo.domain.pasajero.command.AsociarTiqueteAereo;

public class AsociarTiqueteAereoConPasajeroUseCase extends UseCase<RequestCommand<AsociarTiqueteAereo>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AsociarTiqueteAereo> asociarTiqueteAereoRequestCommand) {
        var command = asociarTiqueteAereoRequestCommand.getCommand();
        var pasajero = Pasajero.from(command.getPasajeroId(), retrieveEvents(command.getPasajeroId().value()));
        pasajero.asociarTiqueteAereo(command.getOrigen(), command.getAsiento(), command.getDestino(), command.getEstado());
        emit().onResponse(new ResponseEvents(pasajero.getUncommittedChanges()));

    }
}




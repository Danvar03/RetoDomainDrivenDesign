package com.sofka.retovuelo.usecase.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.retovuelo.domain.pasajero.Pasajero;
import com.sofka.retovuelo.domain.pasajero.command.ModificarTelefono;

public class ModificarTelefonoPasajeroUseCase extends UseCase<RequestCommand<ModificarTelefono>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarTelefono> modificarTelefonoRequestCommand) {
        var command = modificarTelefonoRequestCommand.getCommand();
        var telefono = Pasajero.from(command.getPasajeroId(),retrieveEvents(command.getPasajeroId().value()));
        telefono.modificarTelefonoPasajero(command.getTelefono());
        emit().onResponse(new ResponseEvents(telefono.getUncommittedChanges()));
    }
}
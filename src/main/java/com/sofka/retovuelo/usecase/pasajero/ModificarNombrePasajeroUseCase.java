package com.sofka.retovuelo.usecase.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.retovuelo.domain.pasajero.command.ModificarNombre;
import com.sofka.retovuelo.domain.pasajero.Pasajero;

public class ModificarNombrePasajeroUseCase extends UseCase<RequestCommand<ModificarNombre>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarNombre> modificarNombreRequestCommand) {
        var command = modificarNombreRequestCommand.getCommand();
        var nombre = Pasajero.from(command.getPasajeroId(),retrieveEvents(command.getPasajeroId().value()));
        nombre.modificarNombrePasajero(command.getPasajeroId(),command.getNombre());
        emit().onResponse(new ResponseEvents(nombre.getUncommittedChanges()));
    }
}

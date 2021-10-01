package com.sofka.retovuelo.usecase.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.retovuelo.domain.pasajero.Pasajero;
import com.sofka.retovuelo.domain.pasajero.command.AsociarDatosPersonalesPasajero;

public class AsociarDatosPasajeroUseCase extends UseCase<RequestCommand<AsociarDatosPersonalesPasajero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsociarDatosPersonalesPasajero> asociarDatosPersonalesPasajeroRequestCommand) {
        var command = asociarDatosPersonalesPasajeroRequestCommand.getCommand();
        var pasajero = Pasajero.from(command.getPasajeroId(), retrieveEvents(command.getDatoId().value()));
        pasajero.agregarDatosPersonalesPasajero(command.getDatoId(), command.getPasajeroId(), command.getCorrreo(),
                command.getDireccion(), command.getFechaNacimiento(), command.getTelefono());
        emit().onResponse(new ResponseEvents(pasajero.getUncommittedChanges()));
    }

}

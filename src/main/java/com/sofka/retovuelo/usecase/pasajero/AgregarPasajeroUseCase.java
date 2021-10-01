package com.sofka.retovuelo.usecase.pasajero;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.retovuelo.domain.pasajero.command.AgregarPasajero;
import com.sofka.retovuelo.domain.pasajero.Pasajero;

public class AgregarPasajeroUseCase extends UseCase<RequestCommand<AgregarPasajero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarPasajero> agregarPasajeroRequestCommand){
               var command =  agregarPasajeroRequestCommand.getCommand();
        var pasajero = new Pasajero(command.getPasajeroId(), command.getNombre());
        emit().onResponse(new ResponseEvents(pasajero.getUncommittedChanges()));

    }

}



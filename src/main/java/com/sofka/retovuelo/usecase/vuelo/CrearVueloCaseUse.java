package com.sofka.retovuelo.usecase.vuelo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.retovuelo.domain.vuelo.Vuelo;
import com.sofka.retovuelo.domain.vuelo.command.CrearVuelo;


public class CrearVueloCaseUse extends UseCase<RequestCommand<CrearVuelo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearVuelo> crearVueloRequestCommand) {
        var command = crearVueloRequestCommand.getCommand();
        var vuelo = new Vuelo(command.getVueloId(), command.getAerolinea(), command.getDuracion(), command.getFecha());
        emit().onResponse(new ResponseEvents(vuelo.getUncommittedChanges()));

    }

}




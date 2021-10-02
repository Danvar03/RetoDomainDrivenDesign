package com.sofka.retovuelo.usecase.vuelo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.retovuelo.domain.vuelo.Vuelo;
import com.sofka.retovuelo.domain.vuelo.command.CambiarDuracion;


public class CambiarDuracionVueloCaseUse extends UseCase<RequestCommand<CambiarDuracion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarDuracion> cambiarDuracionRequestCommand) {
        var command = cambiarDuracionRequestCommand.getCommand();
        var vuelo = Vuelo.from(command.getVueloId(), retrieveEvents(command.getVueloId().value()));
        vuelo.cambiarDuracionDelVuelo(command.getVueloId(),command.getDuracion());
        emit().onResponse(new ResponseEvents(vuelo.getUncommittedChanges()));

    }

}
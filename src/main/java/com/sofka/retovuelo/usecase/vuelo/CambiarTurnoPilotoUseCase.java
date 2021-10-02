package com.sofka.retovuelo.usecase.vuelo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.retovuelo.domain.vuelo.Vuelo;

import com.sofka.retovuelo.domain.vuelo.command.TurnoCambiar;


public class CambiarTurnoPilotoUseCase extends UseCase<RequestCommand<TurnoCambiar>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<TurnoCambiar> turnoCambiadoRequestCommand) {
        var command = turnoCambiadoRequestCommand.getCommand();
        var vuelo = Vuelo.from(command.getVueloId(), retrieveEvents(command.getVueloId().value()));
        vuelo.cambiarTurnoDePiloto(command.getTurno());
        emit().onResponse(new ResponseEvents(vuelo.getUncommittedChanges()));

    }

}
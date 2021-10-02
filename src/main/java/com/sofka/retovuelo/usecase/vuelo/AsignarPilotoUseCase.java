package com.sofka.retovuelo.usecase.vuelo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.retovuelo.domain.vuelo.Vuelo;
import com.sofka.retovuelo.domain.vuelo.command.AgregarPiloto;

public class AsignarPilotoUseCase extends UseCase<RequestCommand<AgregarPiloto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarPiloto> agregarPilotoRequestCommand) {
        var command = agregarPilotoRequestCommand.getCommand();
        var vuelo = Vuelo.from(command.getVueloId(), retrieveEvents(command.getVueloId().value()));
        vuelo.agregarPiloto(command.getPilotoId(), command.getNombre(), command.getTurno());
        emit().onResponse(new ResponseEvents(vuelo.getUncommittedChanges()));

    }

}
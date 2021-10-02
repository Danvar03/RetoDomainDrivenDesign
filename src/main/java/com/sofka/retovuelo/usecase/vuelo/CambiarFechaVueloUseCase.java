package com.sofka.retovuelo.usecase.vuelo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.retovuelo.domain.vuelo.Vuelo;
import com.sofka.retovuelo.domain.vuelo.command.CambiarFecha;

public class CambiarFechaVueloUseCase extends UseCase<RequestCommand<CambiarFecha>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarFecha> cambiarFechaRequestCommand) {
        var command = cambiarFechaRequestCommand.getCommand();
        var vuelo = Vuelo.from(command.getVueloId(), retrieveEvents(command.getVueloId().value()));
        vuelo.cambiarFechayHoraDelVuelo(command.getVueloId(),command.getFecha());
        emit().onResponse(new ResponseEvents(vuelo.getUncommittedChanges()));

    }

}
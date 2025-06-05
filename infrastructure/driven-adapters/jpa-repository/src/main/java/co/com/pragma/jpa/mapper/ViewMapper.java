package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.ViewEntity;
import co.com.pragma.model.ticketing.View;

public class ViewMapper {

    public static View toDomain(ViewEntity viewEntity){
        return View.builder()
                .id(viewEntity.getId())
                .url(viewEntity.getUrl())
                .date(viewEntity.getDate().toString())
                .free(viewEntity.isFree())
                .idTournament(viewEntity.getTournamentId())
                .aforo(viewEntity.getAforo())
                .identifier(viewEntity.getIdentifier())
                .ticketPrice(viewEntity.getTicketPrice())
                .build();
    }
}

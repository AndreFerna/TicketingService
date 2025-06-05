package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.TicketingEntity;
import co.com.pragma.model.ticketing.Ticketing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketingMapper {

    public static TicketingEntity toEntity(Ticketing ticketing, Long viewId, Long urlId){
        return TicketingEntity.builder()
                .numberTickets(ticketing.getNumberTickets())
                .price(ticketing.getPrice())
                /*.date(LocalDateTime.parse("2025-06-05 12:00:00",
                        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))*/
                .date(LocalDateTime.now())
                .used(ticketing.getUsed())
                .uniqueCode(ticketing.getUniqueCode())
                .viewId(viewId)
                .urlId(urlId)
                .userId(ticketing.getUserId())
                .build();
    }

    public static Ticketing toDomain(TicketingEntity ticketingEntity, String identifier, String url){
        return Ticketing.builder()
                .id(ticketingEntity.getId())
                .numberTickets(ticketingEntity.getNumberTickets())
                .price(ticketingEntity.getPrice())
                .date(ticketingEntity.getDate().toString())
                .used(ticketingEntity.getUsed())
                .uniqueCode(ticketingEntity.getUniqueCode())
                .identifier(identifier)
                .url(url)
                .userId(ticketingEntity.getUserId())
                .build();
    }

}

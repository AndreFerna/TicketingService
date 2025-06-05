package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.TicketingRequestDto;
import co.com.pragma.api.dto.TicketingResponseDto;
import co.com.pragma.model.ticketing.Ticketing;
import co.com.pragma.model.ticketing.Url;

import java.util.UUID;

public class TicketingDtoMapper {

    public static Ticketing ticketingDtoToTicketing(TicketingRequestDto ticketingRequestDto, String uniqueCode){
        return  Ticketing.builder()
                .numberTickets(ticketingRequestDto.getNumberTickets())
                .price(ticketingRequestDto.getTotalPrice())
                .used(ticketingRequestDto.getUsed())
                .uniqueCode(uniqueCode)
                .identifier(ticketingRequestDto.getViewIdentifier())
                .url("https://tournament.com/view/?ticketing="+uniqueCode)
                .userId(ticketingRequestDto.getUserId())
                .build();
    }

    public static Url toUrl(String uniqueCode){
        return Url.builder()
                .value("https://tournament.com/view/?ticketing="+uniqueCode)
                .status(true)
                .build();
    }

    public static TicketingResponseDto toTicketingResponseDto(Ticketing ticketing){
        return TicketingResponseDto.builder()
                .id(ticketing.getId())
                .numberTickets(ticketing.getNumberTickets())
                .totalPrice(ticketing.getPrice())
                .date(ticketing.getDate())
                .used(ticketing.getUsed())
                .uniqueCode(ticketing.getUniqueCode())
                .viewIdentifier(ticketing.getIdentifier())
                .url(ticketing.getUrl())
                .userId(ticketing.getUserId())
                .build();
    }

}

package co.com.pragma.usecase.ticketing;

import co.com.pragma.model.ticketing.Ticketing;
import co.com.pragma.model.ticketing.Url;
import co.com.pragma.model.ticketing.View;
import co.com.pragma.model.ticketing.config.ErrorCode;
import co.com.pragma.model.ticketing.config.PragmaException;
import co.com.pragma.model.ticketing.gateways.TicketingRepository;
import co.com.pragma.model.ticketing.gateways.UrlRepository;
import co.com.pragma.model.ticketing.gateways.UserRepository;
import co.com.pragma.model.ticketing.gateways.ViewRepository;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class TicketingUseCase {
    private final TicketingRepository ticketingRepository;
    private final ViewRepository viewRepository;
    private final UrlRepository urlRepository;
    private final UserRepository userRepository;

    public Ticketing save(Ticketing ticketing, Url url){
        Long viewId = validateExistsView(ticketing.getIdentifier());
        validateExistsUser(ticketing.getUserId());
        //Url url = new Url(1L, "https://ticketing.com/?sale=" + ticketing.getUniqueCode(), true);
        Url savedUrl = saveUrlTicketing(url);
        return ticketingRepository.saveTicketing(ticketing, viewId, savedUrl.getId());
    }

    public Url saveUrlTicketing(Url url){
        return  urlRepository.saveUrl(url);
    }

    public Long validateExistsView(String identifier){
        View viewExists = viewRepository.findByIdentifierView(identifier);
        return viewExists.getId();
    }

    private void validateExistsUser(String organizerId) {
        boolean userExists = userRepository.exitsById(organizerId);
        if (!userExists) {
            throw new PragmaException(ErrorCode.B409007);
        }
    }

}

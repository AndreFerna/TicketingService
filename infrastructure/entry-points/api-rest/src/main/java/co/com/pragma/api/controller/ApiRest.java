package co.com.pragma.api.controller;
import co.com.pragma.api.dto.TicketingRequestDto;
import co.com.pragma.api.mapper.TicketingDtoMapper;
import co.com.pragma.model.ticketing.Ticketing;
import co.com.pragma.model.ticketing.Url;
import co.com.pragma.model.ticketing.config.PragmaException;
import co.com.pragma.model.ticketing.config.ErrorCode;
import co.com.pragma.usecase.ticketing.TicketingUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * API Rest controller.
 * 
 * Example of how to declare and use a use case:
 * <pre>
 * private final MyUseCase useCase;
 * 
 * public String commandName() {
 *     return useCase.execute();
 * }
 * </pre>
 */
@RestController
@RequestMapping(value = "/api/ticketing", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private HealthEndpoint healthEndpoint;
    private final TicketingUseCase ticketingUseCase;


    @RequestMapping(path = "/health", method = RequestMethod.HEAD)
    public ResponseEntity<Void> health() {
        HealthComponent healthComponent = healthEndpoint.health();

        if (Status.UP.equals(healthComponent.getStatus())) {
            return ResponseEntity.ok().build();
        } else {
            throw new PragmaException(ErrorCode.SP503);
        }
    }

    @PostMapping
    public Ticketing sale(@RequestBody @Valid TicketingRequestDto ticketingRequestDto){
        String uniqueCode = UUID.randomUUID().toString();
        Ticketing ticketing = TicketingDtoMapper.ticketingDtoToTicketing(ticketingRequestDto, uniqueCode);
        Url url = TicketingDtoMapper.toUrl(uniqueCode);
        return ticketingUseCase.save(ticketing, url);
    }

}

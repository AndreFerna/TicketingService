package co.com.pragma.api.controller;
import co.com.pragma.api.dto.ResponseErrorDto;
import co.com.pragma.api.dto.TicketingRequestDto;
import co.com.pragma.api.mapper.TicketingDtoMapper;
import co.com.pragma.model.ticketing.Ticketing;
import co.com.pragma.model.ticketing.Url;
import co.com.pragma.model.ticketing.config.PragmaException;
import co.com.pragma.model.ticketing.config.ErrorCode;
import co.com.pragma.usecase.ticketing.TicketingUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Metodo que permite monitorear la API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa", content = {@Content(mediaType = "application/json")})
    })
    @RequestMapping(path = "/health", method = RequestMethod.HEAD)
    public ResponseEntity<Void> health() {
        HealthComponent healthComponent = healthEndpoint.health();

        if (Status.UP.equals(healthComponent.getStatus())) {
            return ResponseEntity.ok().build();
        } else {
            throw new PragmaException(ErrorCode.SP503);
        }
    }

    @Operation(summary = "Permite guardar una venta")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TicketingRequestDto.class))}),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))}),
            @ApiResponse(responseCode = "409", description = "Se presentan conflictos con los datos de la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))})
    })
    @PostMapping
    public Ticketing sale(@RequestBody @Valid TicketingRequestDto ticketingRequestDto){
        String uniqueCode = UUID.randomUUID().toString();
        Ticketing ticketing = TicketingDtoMapper.ticketingDtoToTicketing(ticketingRequestDto, uniqueCode);
        Url url = TicketingDtoMapper.toUrl(uniqueCode);
        return ticketingUseCase.save(ticketing, url);
    }

}
